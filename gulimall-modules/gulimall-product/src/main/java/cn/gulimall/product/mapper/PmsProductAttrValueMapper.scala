package cn.gulimall.product.mapper

import cn.gulimall.demo.model.po.PmsProductAttrValue
import cn.gulimall.demo.model.po.table.PmsProductAttrValueTableDef
import com.mybatisflex.core.BaseMapper
import com.mybatisflex.core.query.QueryWrapper
import org.apache.ibatis.annotations.Mapper

import java.util

/**
 *
 * @author zhanghaofei
 *         Create at 2025/9/4
 */
@Mapper
trait PmsProductAttrValueMapper extends BaseMapper[PmsProductAttrValue]{

  def listBySpuId(spuId: Long): util.List[PmsProductAttrValue] = {
    selectListByQuery(QueryWrapper.create()
      .where(PmsProductAttrValueTableDef.PMS_PRODUCT_ATTR_VALUE.SPU_ID.eq(spuId)))
  }


}
