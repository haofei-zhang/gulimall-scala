package cn.gulimall.demo.service.impl

import cn.dev33.satoken.stp.{SaTokenInfo, StpUtil}
import cn.gulimall.demo.mapper.{SysMenuMapper, SysRoleMenuMapper, SysUserMapper, SysUserRoleMapper}
import cn.gulimall.demo.model.dto.LoginDto
import cn.gulimall.demo.model.po.SysMenu
import cn.gulimall.demo.model.vo.SysMenuVo
import cn.gulimall.demo.service.SysLoginService
import cn.hutool.core.collection.CollUtil
import com.alibaba.fastjson2.JSONObject
import org.apache.commons.codec.digest.DigestUtils
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service

import java.{lang, util}
import java.util.Objects
import java.util.stream.Collectors

/**
 * 2024/5/10 下午11:32
 * @author Z
 *
 */
@Service
class SysLoginServiceImpl(sysUserMapper: SysUserMapper,
                          sysUserRoleMapper: SysUserRoleMapper,
                          sysRoleMenuMapper: SysRoleMenuMapper,
                          sysMenuMapper: SysMenuMapper) extends SysLoginService {

  private def log: Logger = LoggerFactory.getLogger(classOf[SysLoginServiceImpl])

  override def login(loginDto: LoginDto): SaTokenInfo = {
    val user = sysUserMapper.selectByMobile(loginDto.getMobile)
    if (Objects.isNull(user)){
      throw new RuntimeException("用户不存在")
    }
    if (!Objects.equals(user.getPassword, DigestUtils.sha256Hex(loginDto.getPassword))){
      throw new RuntimeException("密码错误")
    }
    StpUtil.login(user.getId)

    StpUtil.getTokenInfo
  }

  override def logout(): Unit = {
    StpUtil.logout()
  }

  override def getUserMenuList(userId: Long): util.List[SysMenuVo] = {
    getMenuList(null)
  }

  /**
   * 获取用户权限
   *
   * @return
   */
  override def getUserPermissions(userId: Long): util.List[String] = {
    val menuList = sysMenuMapper.selectAll()
    val roleIds = sysUserRoleMapper.getRoleIdList(userId)
    val menuIds = sysRoleMenuMapper.getMenuIdList(roleIds)
    //开发测试，返回所有的数据
    menuList.stream()
//      .filter(menu => menuIds.contains(menu.getId))
      .map((menu: SysMenu) => menu.getPerms).collect(Collectors.toList())
  }

  /**
   * 获取用户菜单
   *
   * @param userId
   * @return
   */
  override def getUserMenu(userId: Long): JSONObject = {
    val menuList = getUserMenuList(userId)
    val permsList = getUserPermissions(userId)
    val data = new JSONObject()
    data.put("menuList", menuList)
    data.put("permissions", permsList)
    data
  }

  def getMenuList(list: util.List[Long]): util.List[SysMenuVo] = {
    val menuList = sysMenuMapper.getMenuList(list)
    val menuMap: util.Map[lang.Long, util.List[SysMenuVo]] = menuList.stream().map(x => {
      //TODO 后面要用mapstruct
      val sysMenuVo = new SysMenuVo()
      BeanUtils.copyProperties(x, sysMenuVo)
      sysMenuVo
    }).collect(Collectors.groupingBy((x: SysMenuVo) => x.getParentId))
    val parentList = menuMap.get(0L)
    fillChildrenMenu(parentList, menuMap)
    parentList
  }

  def fillChildrenMenu(list: util.List[SysMenuVo], map: util.Map[lang.Long, util.List[SysMenuVo]]): Unit = {
    if (CollUtil.isEmpty(list)){
      return
    }
    list.forEach(x => {
      val children = map.get(x.getId)
      fillChildrenMenu(children, map)
      x.setChildren(children)
    })
  }

}
