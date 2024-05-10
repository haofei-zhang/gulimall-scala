package cn.gulimall.demo.controller

import cn.gulimall.demo.model.vo.ResultVo
import cn.gulimall.demo.service.SysLoginService
import org.springframework.web.bind.annotation.{PostMapping, RestController}

/**
 * @author Z
 */
@RestController
class SysLoginController(sysLoginService: SysLoginService) {


  @PostMapping(Array("/login"))
  def login(): ResultVo = {
    sysLoginService.login()
    ResultVo.ok()
  }

  @PostMapping(Array("/logout"))
  def logout(): ResultVo = {
    ResultVo.ok()
  }


}
