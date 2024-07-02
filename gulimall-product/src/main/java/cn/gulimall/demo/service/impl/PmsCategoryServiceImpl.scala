package cn.gulimall.demo.service.impl

import cn.gulimall.demo.mapper.PmsCategoryMapper
import cn.gulimall.demo.model.po.PmsCategory
import cn.gulimall.demo.service.PmsCategoryService
import org.springframework.stereotype.Service

import java.util

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
  override def listWithTree(): util.List[PmsCategory] = {
    val categoryList = pmsCategoryMapper.selectAll()
    categoryList
  }
}
