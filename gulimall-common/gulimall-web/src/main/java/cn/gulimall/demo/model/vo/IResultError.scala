package cn.gulimall.demo.model.vo

/**
 * @author Z
 */
trait IResultError {
  /**
   * 错误码
   * @return
   */
  def getCode: Integer

  /**
   * 错误信息
   * @return
   */
  def getMsg: String

}
