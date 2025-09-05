package cn.gulimall.product.mapper

import cn.gulimall.demo.model.po.PmsAttr
import cn.gulimall.demo.model.po.table.PmsAttrTableDef
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
trait PmsAttrMapper extends BaseMapper[PmsAttr]{

  def listIdByAttrIdList(attrIdList: util.List[Integer]): util.List[Integer] ={
    selectObjectListByQueryAs(
      QueryWrapper.create()
        .select(PmsAttrTableDef.PMS_ATTR.ATTR_ID)
        .where(PmsAttrTableDef.PMS_ATTR.ATTR_ID.in(attrIdList))
        .where(PmsAttrTableDef.PMS_ATTR.SEARCH_TYPE.eq(1))
      , classOf[Integer])
  }

}
