package cn.gulimall.demo.service.impl

import cn.dev33.satoken.stp.{SaTokenInfo, StpUtil}
import cn.gulimall.demo.converter.MenuConverter
import cn.gulimall.demo.mapper.{SysMenuMapper, SysRoleMenuMapper, SysUserMapper, SysUserRoleMapper}
import cn.gulimall.demo.model.dto.LoginDto
import cn.gulimall.demo.model.po.SysMenu
import cn.gulimall.demo.model.vo.SysMenuVo
import cn.gulimall.demo.service.SysLoginService
import cn.hutool.core.collection.CollUtil
import com.alibaba.fastjson2.JSONObject
import lombok.extern.slf4j.Slf4j
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
                          sysMenuMapper: SysMenuMapper,
                          menuConverter: MenuConverter) extends ServiceImpl with SysLoginService {

  override def login(loginDto: LoginDto): SaTokenInfo = {
    val user = sysUserMapper.selectByMobile(loginDto.getMobile)
    if (Objects.isNull(user)){
      throw new RuntimeException("用户不存在")
    }
    if (!Objects.equals(user.getPassword, DigestUtils.sha256Hex(loginDto.getPassword))){
      throw new RuntimeException("密码错误")
    }
    StpUtil.login(user.getUserId)
    StpUtil.getTokenInfo
  }

  override def logout(): Unit = {
    StpUtil.logout()
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

  override def getUserMenuList(userId: Long): util.List[SysMenuVo] = {
    getMenuList(null)
  }

  def getMenuList(list: util.List[Long]): util.List[SysMenuVo] = {
    val menuList = sysMenuMapper.getMenuList(list)
    val menuMap: util.Map[lang.Integer, util.List[SysMenuVo]] = menuList.stream()
      .map(x => {
      menuConverter.toVo(x)
    })
      .collect(Collectors.groupingBy((x: SysMenuVo) => x.getParentId))
    val parentList = menuMap.get(0)
    menuConverter.fillChildrenMenu(parentList, menuMap)
    parentList
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
      .map((menu: SysMenu) => menu.getPerms)
      .distinct()
      .filter(x => Objects.nonNull(x))
      .collect(Collectors.toList())
  }

}
