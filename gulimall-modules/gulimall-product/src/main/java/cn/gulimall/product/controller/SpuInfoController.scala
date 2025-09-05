package cn.gulimall.product.controller

import cn.gulimall.web.model.vo.ResultVo
import org.springframework.web.bind.annotation.{PathVariable, PostMapping, RequestMapping, RestController}

/**
 *
 * @author zhanghaofei
 *         Create at 2025/9/4
 */
@RestController
@RequestMapping(Array("/spuInfo"))
class SpuInfoController {

  @PostMapping(Array("/{id}/up"))
  def up(@PathVariable id: Long): ResultVo = {
    ResultVo.ok()
  }

}
