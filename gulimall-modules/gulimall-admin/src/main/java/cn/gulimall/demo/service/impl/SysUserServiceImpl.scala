package cn.gulimall.demo.service.impl

import cn.gulimall.demo.mapper.SysUserMapper
import cn.gulimall.demo.model.po.SysUser
import cn.gulimall.demo.service.SysUserService
import org.springframework.stereotype.Service

/**
 *
 * @author Z
 * @since 2024/5/29 下午11:14
 */
@Service
class SysUserServiceImpl(sysUserMapper: SysUserMapper) extends ServiceImpl with SysUserService{

  /**
   * 根据id查询
   *
   * @param id
   */
  override def getById(id: Long): SysUser = {
    sysUserMapper.selectOneById(id)
  }
}
