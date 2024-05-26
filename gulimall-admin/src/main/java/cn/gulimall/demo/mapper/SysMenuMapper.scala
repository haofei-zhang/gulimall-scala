package cn.gulimall.demo.mapper

import cn.gulimall.demo.model.po.SysMenu
import cn.gulimall.demo.model.po.table.SysMenuTableDef
import com.mybatisflex.core.BaseMapper
import com.mybatisflex.core.query.QueryWrapper
import org.apache.ibatis.annotations.Mapper

import java.util

/**
 *
 * @author Z
 * @since 2024/5/21 下午11:07
 */
@Mapper
trait SysMenuMapper extends BaseMapper[SysMenu]{

  def getMenuList(list: util.List[Long]): util.List[SysMenu] = {
    val query = QueryWrapper.create()
      .select()
      .where(SysMenuTableDef.SYS_MENU.ID.in(list)).where(SysMenuTableDef.SYS_MENU.TYPE.in(List(0,1)))
    selectListByQuery(query)
  }

}
