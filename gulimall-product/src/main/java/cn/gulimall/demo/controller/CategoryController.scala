package cn.gulimall.demo.controller

import cn.gulimall.demo.model.vo.ResultVo
import cn.gulimall.demo.service.PmsCategoryService
import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

/**
 *
 * @author Z
 * @since 2024/7/2 下午11:21
 */
@RestController
@RequestMapping(Array("/category"))
class CategoryController(pmsCategoryService: PmsCategoryService) {

  @GetMapping(Array("/list/tree"))
  def listWithTree(): ResultVo = {
    ResultVo.ok(pmsCategoryService.listWithTree())
  }

}
