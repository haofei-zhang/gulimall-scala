package cn.gulimall.product.mapper

import cn.gulimall.demo.model.po.PmsSkuInfo
import cn.gulimall.demo.model.po.table.PmsSkuInfoTableDef
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
trait PmsSkuInfoMapper extends BaseMapper[PmsSkuInfo]{

  def selectBySpuId(spuId: Long): util.List[PmsSkuInfo] = {
    selectListByQuery(QueryWrapper.create()
    .where(PmsSkuInfoTableDef.PMS_SKU_INFO.SPU_ID.eq(spuId)))
  }

}
