package cn.gulimall.demo.service.impl

import cn.gulimall.demo.mapper.PmsCategoryMapper
import cn.gulimall.demo.model.dto.PmsCategoryDto
import cn.gulimall.demo.model.po.PmsCategory
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

  override def listWithTree(): util.List[PmsCategoryVo] = {
    val categoryList = pmsCategoryMapper.selectAll()

    val categoryMap: util.Map[lang.Integer, util.List[PmsCategoryVo]] = categoryList.stream().map(category => {
      val vo = new PmsCategoryVo
      BeanUtils.copyProperties(category, vo)
      vo
    }).collect(Collectors.groupingBy((x: PmsCategoryVo) => x.getParentCid))

    val rootCategory = categoryMap.get(0)

    fillChildren(rootCategory, categoryMap)

    rootCategory
  }

  def fillChildren(list: util.List[PmsCategoryVo], map: util.Map[lang.Integer, util.List[PmsCategoryVo]]): Unit = {
    if (CollUtil.isEmpty(list)){
      return
    }
    list.forEach(x => {
      val children = map.get(x.getCatId)
      fillChildren(children, map)
      x.setChildren(children)
    })
  }


  override def insert(pmsCategoryDto: PmsCategoryDto): Unit = {
    val category = new PmsCategory
    BeanUtils.copyProperties(pmsCategoryDto, category)
    pmsCategoryMapper.insert(category)
  }

  override def update(pmsCategoryDto: PmsCategoryDto): Unit = {
    val category = new PmsCategory
    BeanUtils.copyProperties(pmsCategoryDto, category)
    pmsCategoryMapper.update(category)
  }
}
