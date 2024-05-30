package cn.gulimall.demo.service

import cn.dev33.satoken.stp.SaTokenInfo
import cn.gulimall.demo.model.dto.LoginDto
import java.util

/**
 *
 * @author Z
 * @since 2024/5/10 下午11:29
 */
trait SysLoginService {

  /**
   * 登陆验证
   * @param loginDto
   * @return
   */
  def login(loginDto: LoginDto): SaTokenInfo

  /**
   * 登出
   */
  def logout(): Unit

  /**
   * 获取用户权限
   * @return
   */
  def getUserPermissions(userId: Long): util.List[String]

}
