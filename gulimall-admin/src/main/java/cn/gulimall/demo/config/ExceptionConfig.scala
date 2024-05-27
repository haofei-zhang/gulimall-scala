package cn.gulimall.demo.config

import cn.gulimall.demo.model.vo.ResultVo
import org.springframework.web.bind.annotation.{ExceptionHandler, RestControllerAdvice}

/**
 *
 * @author Z
 * @since 2024/5/25 下午9:36
 */
@RestControllerAdvice
class ExceptionConfig {

  @ExceptionHandler(Array(classOf[Throwable]))
  def exception():ResultVo = {
    ResultVo.error()
  }

}
