package cn.gulimall.admin.config

import cn.dev33.satoken.exception.SaTokenException
import cn.gulimall.web.model.vo.{ResultError, ResultVo}
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.web.bind.annotation.{ExceptionHandler, RestControllerAdvice}

/**
 *
 * @author Z
 * @since 2024/5/25 下午9:36
 */
@RestControllerAdvice
class ExceptionConfig {

  val log: Logger = LoggerFactory.getLogger(classOf[ExceptionConfig])

  @ExceptionHandler(Array(classOf[Exception]))
  def exception(exception: Exception):ResultVo = {
    log.error(exception.getMessage, exception)
    ResultVo.error()
  }

  @ExceptionHandler(Array(classOf[SaTokenException]))
  def saTokenException(exception: SaTokenException): ResultVo = {
    log.error(exception.getMessage, exception)
    ResultVo.error(ResultError.UNAUTHORIZED)
  }

}
