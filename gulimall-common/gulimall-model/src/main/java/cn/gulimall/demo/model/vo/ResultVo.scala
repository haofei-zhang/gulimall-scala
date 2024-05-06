package cn.gulimall.demo.model.vo

import com.alibaba.fastjson2.JSONObject

/**
 * @author Z
 */
class ResultVo extends JSONObject {

}

object ResultVo {

  private def getInstance(error: IResultError): ResultVo = {
    val r = new ResultVo
    r.put("code", error.getCode)
    r.put("msg", error.getMsg)
    r
  }

  def ok(): ResultVo = {
    getInstance(ResultError.OK)
  }

  def error(): ResultVo = {
    getInstance(ResultError.ERROR)
  }

}
