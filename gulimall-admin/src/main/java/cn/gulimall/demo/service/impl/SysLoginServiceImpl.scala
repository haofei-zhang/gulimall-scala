package cn.gulimall.demo.service.impl

import cn.dev33.satoken.stp.StpUtil
import cn.gulimall.demo.service.SysLoginService
import org.springframework.stereotype.Service

/**
 *
 * @author Z
 * @date 2024/5/10 下午11:32
 */
@Service
class SysLoginServiceImpl extends SysLoginService {

  override def login(): Unit = {
    StpUtil.login(1)
  }

  override def logout(): Unit = {
    StpUtil.logout()
  }
}
