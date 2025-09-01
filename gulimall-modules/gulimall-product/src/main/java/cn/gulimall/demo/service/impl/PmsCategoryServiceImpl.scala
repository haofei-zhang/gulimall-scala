package cn.gulimall.demo.service.impl

import cn.gulimall.demo.converter.CategoryConverter
import cn.gulimall.demo.mapper.PmsCategoryMapper
import cn.gulimall.demo.model.dto.PmsCategoryDto
import cn.gulimall.demo.model.vo.PmsCategoryVo
import cn.gulimall.demo.service.PmsCategoryService
import cn.hutool.core.collection.CollUtil
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service

import java.util.Objects
import java.util.stream.Collectors
import java.{lang, util}

/**
 *
 * @author Z
 * @since 2024/7/2 下午11:23
 */
@Service
class PmsCategoryServiceImpl(pmsCategoryMapper: PmsCategoryMapper,
                             categoryConverter: CategoryConverter) extends PmsCategoryService{

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
    val category = categoryConverter.toPo(pmsCategoryDto)
    if (Objects.isNull(category.getParentCid)) {
      category.setCatLevel(1)
    } else {
      val parent = pmsCategoryMapper.selectOneById(category.getParentCid)
      if (Objects.isNull(parent)) {
        throw new RuntimeException("父分类不存在")
      }
      category.setCatLevel(parent.getCatLevel + 1)
    }
    if (Integer.compare(category.getCatLevel, 3) > 0) {
      throw new RuntimeException("最多支持三级分类")
    }
    pmsCategoryMapper.insert(category)
  }

  override def update(pmsCategoryDto: PmsCategoryDto): Unit = {
    val category = categoryConverter.toPo(pmsCategoryDto)
    category.setCatLevel(null)
    category.setParentCid(null)
    pmsCategoryMapper.update(category)
  }

  /**
   * 批量删除
   *
   * @param ids
   */
  override def delete(ids: util.List[Integer]): Unit = {
    val children = pmsCategoryMapper.listByParentCid(ids)
    if (CollUtil.isNotEmpty(children)) {
      throw new RuntimeException("存在子分类，无法删除")
    }
    pmsCategoryMapper.deleteBatchByIds(ids)
  }
}
