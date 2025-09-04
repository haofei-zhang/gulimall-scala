package cn.gulimall.admin.controller

import cn.dev33.satoken.stp.StpUtil
import cn.gulimall.admin.service.SysUserService
import cn.gulimall.web.model.vo.ResultVo
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
