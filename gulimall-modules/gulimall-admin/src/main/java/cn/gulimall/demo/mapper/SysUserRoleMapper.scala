package cn.gulimall.demo.mapper

import cn.gulimall.demo.model.po.SysUserRole
import cn.gulimall.demo.model.po.table.SysUserRoleTableDef
import com.mybatisflex.core.BaseMapper
import com.mybatisflex.core.query.QueryWrapper
import org.apache.ibatis.annotations.Mapper
import java.util
/**
 *
 * @author Z
 * @since 2024/5/30 下午11:25
 */
@Mapper
trait SysUserRoleMapper extends BaseMapper[SysUserRole]{

  def getRoleIdList(userId: Long): util.List[Long] = {
    val query = QueryWrapper.create()
      .select(SysUserRoleTableDef.SYS_USER_ROLE.ROLE_ID)
      .where(SysUserRoleTableDef.SYS_USER_ROLE.USER_ID.eq(userId))
    selectObjectListByQueryAs(query, classOf[Long])
  }

}
