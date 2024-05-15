package cn.gulimall.demo.service

import cn.gulimall.demo.model.dto.LoginDto

/**
 *
 * @author Z
 * @since 2024/5/10 下午11:29
 */
trait SysLoginService {

  def login(loginDto: LoginDto): Unit

  def logout(): Unit

}
