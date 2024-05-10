package cn.gulimall.demo.service

import org.springframework.stereotype.Service

/**
 *
 * @author Z
 * @date 2024/5/10 下午11:29
 */
trait SysLoginService {

  def login(): Unit

  def logout(): Unit

}
