package cn.gulimall.admin.mapper

import cn.gulimall.demo.model.po.SysRoleMenu
import cn.gulimall.demo.model.po.table.SysRoleMenuTableDef
import cn.hutool.core.collection.CollUtil
import com.mybatisflex.core.BaseMapper
import com.mybatisflex.core.query.QueryWrapper
import org.apache.ibatis.annotations.Mapper

import java.util

/**
 *
 * @author Z
 * @since 2024/5/30 下午11:27
 */
@Mapper
trait SysRoleMenuMapper extends BaseMapper[SysRoleMenu]{
  def getMenuIdList(roleIds: util.List[Long]): util.List[Long] = {
    val query = QueryWrapper.create()
      .select(SysRoleMenuTableDef.SYS_ROLE_MENU.MENU_ID)
      .where(SysRoleMenuTableDef.SYS_ROLE_MENU.ROLE_ID.in(roleIds, CollUtil.isNotEmpty(roleIds)))
    selectObjectListByQueryAs(query, classOf[Long])
  }

}
