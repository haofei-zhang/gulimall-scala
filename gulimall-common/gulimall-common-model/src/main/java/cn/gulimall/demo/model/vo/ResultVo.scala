package cn.gulimall.demo.model.vo

import com.alibaba.fastjson2.JSONObject

/**
 * @author Z
 */
class ResultVo extends JSONObject {

  override def put(key: String, value: AnyRef): ResultVo = {
    super.put(key, value)
    this
  }

}

object ResultVo {

  private def getInstance(error: IResultError): ResultVo = {
    new ResultVo().put("code", error.getCode).put("msg", error.getMsg)
  }

  def ok(): ResultVo = {
    getInstance(ResultError.OK)
  }

  def ok(data: AnyRef): ResultVo = {
    getInstance(ResultError.OK).put("data", data)
  }

  def error(): ResultVo = {
    getInstance(ResultError.ERROR)
  }

  def error(msg: String): ResultVo = {
    getInstance(ResultError.ERROR).put("msg", msg)
  }

}
