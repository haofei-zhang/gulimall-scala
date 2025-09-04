package cn.gulimall.product.mapper

import cn.gulimall.demo.model.po.PmsCategory
import cn.gulimall.demo.model.po.table.PmsCategoryTableDef
import cn.hutool.core.collection.CollUtil
import com.mybatisflex.core.BaseMapper
import com.mybatisflex.core.query.QueryWrapper
import org.apache.ibatis.annotations.Mapper

import java.util

/**
 *
 * @author Z
 * @since 2024/7/2 下午11:22
 */
@Mapper
trait PmsCategoryMapper extends BaseMapper[PmsCategory]{

  def listByParentCid(parentCids: util.List[Integer]): util.List[PmsCategory] = {
    val query = QueryWrapper.create()
      .select()
      .where(PmsCategoryTableDef.PMS_CATEGORY.PARENT_CID.in(parentCids, CollUtil.isNotEmpty(parentCids)))
    selectListByQuery(query)
  }

}
