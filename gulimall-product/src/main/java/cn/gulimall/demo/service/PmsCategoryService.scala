package cn.gulimall.demo.service

import cn.gulimall.demo.model.dto.PmsCategoryDto
import cn.gulimall.demo.model.vo.PmsCategoryVo

import java.util

/**
 *
 * @author Z
 * @since 2024/7/2 下午11:23
 */
trait PmsCategoryService {

  /**
   * 获取树形结构分类
   * @return
   */
  def listWithTree(): util.List[PmsCategoryVo]

  /**
   * 添加分类
   * @param pmsCategoryDto
   */
  def insert(pmsCategoryDto: PmsCategoryDto): Unit

  /**
   * 修改分类
   * @param pmsCategoryDto
   */
  def update(pmsCategoryDto: PmsCategoryDto): Unit

}
