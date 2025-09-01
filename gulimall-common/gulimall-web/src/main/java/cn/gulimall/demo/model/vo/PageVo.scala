package cn.gulimall.demo.model.vo

/**
 * @author Z
 */
class PageVo(list: List[_], total: Long, page: Int, limit: Int) {

}

object PageVo {

  def reset(list: List[_]): Unit = {
    //TODO 根据具体分页框架完成实现
  }

}
