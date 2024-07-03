package cn.gulimall.demo.service.impl

import cn.gulimall.demo.mapper.PmsCategoryMapper
import cn.gulimall.demo.model.vo.PmsCategoryVo
import cn.gulimall.demo.service.PmsCategoryService
import cn.hutool.core.collection.CollUtil
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service

import java.{lang, util}
import java.util.stream.Collectors

/**
 *
 * @author Z
 * @since 2024/7/2 下午11:23
 */
@Service
class PmsCategoryServiceImpl(pmsCategoryMapper: PmsCategoryMapper) extends PmsCategoryService{

  /**
   * 获取树形结构分类
   *
   * @return
   */
  override def listWithTree(): util.List[PmsCategoryVo] = {
    val categoryList = pmsCategoryMapper.selectAll()

    val categoryMap: util.Map[lang.Long, util.List[PmsCategoryVo]] = categoryList.stream().map(category => {
      val vo = new PmsCategoryVo
      BeanUtils.copyProperties(category, vo)
      vo
    }).collect(Collectors.groupingBy((x: PmsCategoryVo) => x.getParentCid))

    val rootCategory = categoryMap.get(0L)

    fillChildren(rootCategory, categoryMap)

    rootCategory
  }

  def fillChildren(list: util.List[PmsCategoryVo], map: util.Map[lang.Long, util.List[PmsCategoryVo]]): Unit = {
    if (CollUtil.isEmpty(list)){
      return
    }
    list.forEach(x => {
      val children = map.get(x.getCatId)
      fillChildren(children, map)
      x.setChildren(children)
    })
  }

}
