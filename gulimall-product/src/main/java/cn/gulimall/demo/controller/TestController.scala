package cn.gulimall.demo.controller

import org.springframework.web.bind.annotation.{GetMapping, RequestMapping, RestController}

/**
 *
 * @author Z
 * @date 2024/5/1 12:42
 */
@RestController
@RequestMapping(Array("/test"))
class TestController {

  @GetMapping(Array("/test1"))
  def test1(): Unit = {
    println("test1")
  }

}
