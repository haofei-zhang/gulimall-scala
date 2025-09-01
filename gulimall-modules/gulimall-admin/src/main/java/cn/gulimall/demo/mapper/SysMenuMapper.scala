package cn.gulimall.demo.mapper

import cn.gulimall.demo.model.po.SysMenu
import cn.gulimall.demo.model.po.table.SysMenuTableDef
import cn.hutool.core.collection.CollUtil
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
      .where(SysMenuTableDef.SYS_MENU.TYPE.in(util.Arrays.asList(0,1)))
      .where(SysMenuTableDef.SYS_MENU.MENU_ID.in(list, CollUtil.isNotEmpty(list)))
    selectListByQuery(query)
  }

}
