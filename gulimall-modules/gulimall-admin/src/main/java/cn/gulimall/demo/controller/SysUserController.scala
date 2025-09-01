package cn.gulimall.demo.controller

import cn.dev33.satoken.stp.StpUtil
import cn.gulimall.demo.model.vo.ResultVo
import cn.gulimall.demo.service.SysUserService
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

/**
 *
 * @author Z
 * @since 2024/5/28 下午11:36
 */
@RestController
@RequestMapping(Array("/sys/user"))
class SysUserController (sysUserService: SysUserService){

  @GetMapping(Array("/info"))
  def info(): ResultVo = {
    val user = sysUserService.getById(StpUtil.getLoginIdAsLong)
    ResultVo.ok(user)
  }

}
