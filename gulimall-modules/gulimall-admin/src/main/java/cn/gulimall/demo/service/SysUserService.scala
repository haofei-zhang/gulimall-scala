package cn.gulimall.demo.service

import cn.gulimall.demo.model.po.SysUser

/**
 *
 * @author Z
 * @since 2024/5/29 下午11:12
 */
trait SysUserService {

  /**
   * 根据id查询
   * @param id
   */
  def getById(id: Long): SysUser


}
