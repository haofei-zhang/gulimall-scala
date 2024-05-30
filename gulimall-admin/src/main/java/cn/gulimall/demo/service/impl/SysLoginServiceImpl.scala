package cn.gulimall.demo.service.impl

import cn.dev33.satoken.stp.{SaTokenInfo, StpUtil}
import cn.gulimall.demo.mapper.{SysMenuMapper, SysRoleMenuMapper, SysUserMapper, SysUserRoleMapper}
import cn.gulimall.demo.model.dto.LoginDto
import cn.gulimall.demo.model.po.SysMenu
import cn.gulimall.demo.service.SysLoginService
import org.apache.commons.codec.digest.DigestUtils
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.stereotype.Service

import java.util
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

  /**
   * 获取用户权限
   *
   * @return
   */
  override def getUserPermissions(userId: Long): util.List[String] = {
    val menuList = sysMenuMapper.selectAll()

    val roleIds = sysUserRoleMapper.getRoleIdList(userId)

    val menuIds = sysRoleMenuMapper.getMenuIdList(roleIds)

    menuList.stream().filter(menu => menuIds.contains(menu.getId)).map((menu: SysMenu) => menu.getPerms).collect(Collectors.toList())
  }
}
