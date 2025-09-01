package cn.gulimall.demo.mapper

import cn.gulimall.demo.model.po.SysUser
import cn.gulimall.demo.model.po.table.SysUserTableDef
import com.mybatisflex.core.BaseMapper
import com.mybatisflex.core.query.QueryWrapper
import org.apache.ibatis.annotations.Mapper

/**
 * 2024/5/12 下午2:05
 *
 * @author Z
 */
@Mapper
trait SysUserMapper extends BaseMapper[SysUser]{

  def selectByMobile(mobile: Any): SysUser = {
    val queryWrapper = QueryWrapper.create()
      .select().where(SysUserTableDef.SYS_USER.MOBILE.eq(mobile))
    selectOneByQuery(queryWrapper)
  }


}
