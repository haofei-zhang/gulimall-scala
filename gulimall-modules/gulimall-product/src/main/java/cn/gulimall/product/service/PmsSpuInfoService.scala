package cn.gulimall.product.service

/**
 *
 * @author zhanghaofei
 *         Create at 2025/9/4
 */
trait PmsSpuInfoService {

  /**
   * 商品上架
   * @param id
   */
  def up(id: Long): Unit

}
