package cn.gulimall.demo.controller

import cn.gulimall.demo.model.dto.LoginDto
import cn.gulimall.demo.model.vo.ResultVo
import cn.gulimall.demo.service.SysLoginService
import org.springframework.web.bind.annotation.{PostMapping, RequestBody, RestController}

/**
 * @author Z
 */
@RestController
class SysLoginController(sysLoginService: SysLoginService) {


  @PostMapping(Array("/login"))
  def login(@RequestBody loginDto: LoginDto): ResultVo = {
    sysLoginService.login(loginDto)
    ResultVo.ok()
  }

  @PostMapping(Array("/logout"))
  def logout(): ResultVo = {
    ResultVo.ok()
  }


}
