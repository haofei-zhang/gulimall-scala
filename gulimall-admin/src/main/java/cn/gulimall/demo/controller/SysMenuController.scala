package cn.gulimall.demo.controller

import cn.gulimall.demo.model.vo.ResultVo
import cn.gulimall.demo.service.SysMenuService
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

/**
 *
 * @author Z
 * @since 2024/5/19 下午11:52
 */
@RestController
@RequestMapping(Array("/sys/menu"))
class SysMenuController (sysMenuService: SysMenuService){

  @GetMapping(Array("/nav"))
  def nav(): ResultVo = {
    val menuList = sysMenuService.getUserMenuList(1L)
    val r = ResultVo.ok()
    r.put("menuList", menuList)
    r
  }

}
