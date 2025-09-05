package cn.gulimall.product.service.impl

import cn.gulimall.core.service.impl.ServiceImpl
import cn.gulimall.product.mapper.{PmsAttrMapper, PmsProductAttrValueMapper, PmsSkuInfoMapper, PmsSpuInfoMapper}
import cn.gulimall.product.service.PmsSpuInfoService
import cn.gulimall.search.model.po.SkuEsModel
import org.springframework.stereotype.Service

import java.util.stream.Collectors
import java.util

/**
 *
 * @author zhanghaofei
 *         Create at 2025/9/4
 */
@Service
class PmsSpuInfoServiceImpl(pmsSpuInfoMapper: PmsSpuInfoMapper,
                            pmsSkuInfoMapper: PmsSkuInfoMapper,
                            pmsAttrMapper: PmsAttrMapper,
                            pmsProductAttrValueMapper: PmsProductAttrValueMapper) extends ServiceImpl with PmsSpuInfoService{

  /**
   * 商品上架
   * 处理要上架的sku数据
   * @param id spuId
   */
  override def up(id: Long): Unit = {
    //查出当前spuId对应的所有sku信息，品牌的名字
    val skuInfoList = pmsSkuInfoMapper.selectBySpuId(id)

    val baseAttrs = pmsProductAttrValueMapper.listBySpuId(id)
    val attrIdList: util.List[Integer] = baseAttrs.stream()
      .map(attr => attr.getAttrId)
      .collect(Collectors.toList())

    val attrList = pmsAttrMapper.listIdByAttrIdList(attrIdList)

    val esAttrList = baseAttrs.stream()
      .filter(attr => attrList.contains(attr))
      .map(attr => {
        val esAttr = new SkuEsModel.Attrs()
        esAttr
      })
      .collect(Collectors.toList())


    skuInfoList.stream()
      .map(skuInfo => {
        //组装需要的数据
        val skuEsModel = new SkuEsModel()
        //TODO 发送远程调用，库存系统查询是否有库存
        //TODO 热度评分
        //TODO 查询品牌和分类的名字信息
      })
      .collect(Collectors.toList())
  }
}
