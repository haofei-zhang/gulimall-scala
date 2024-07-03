package cn.gulimall.demo.service

import cn.gulimall.demo.model.po.PmsCategory
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

}
