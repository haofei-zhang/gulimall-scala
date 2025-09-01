package cn.gulimall.demo.controller

import cn.dev33.satoken.stp.StpUtil
import cn.gulimall.demo.model.vo.ResultVo
import cn.gulimall.demo.service.{SysLoginService, SysMenuService}
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

/**
 *
 * @author Z
 * @since 2024/5/19 下午11:52
 */
@RestController
@RequestMapping(Array("/sys/menu"))
class SysMenuController (sysMenuService: SysMenuService,
                         sysLoginService: SysLoginService){

  @GetMapping(Array("/nav"))
  def nav(): ResultVo = {
    val data = sysLoginService.getUserMenu(StpUtil.getLoginIdAsLong)
    ResultVo.ok(data)
  }

}
