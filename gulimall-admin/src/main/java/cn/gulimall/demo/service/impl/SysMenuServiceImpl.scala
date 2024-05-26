package cn.gulimall.demo.service.impl

import cn.gulimall.demo.mapper.SysMenuMapper
import cn.gulimall.demo.model.vo.SysMenuVo
import cn.gulimall.demo.service.SysMenuService
import cn.hutool.core.collection.CollUtil
import org.springframework.beans.BeanUtils
import org.springframework.stereotype.Service

import java.util.stream.Collectors
import java.{lang, util}

/**
 *
 * @author Z
 * @since 2024/5/21 下午11:09
 */
@Service
class SysMenuServiceImpl(sysMenuMapper: SysMenuMapper) extends SysMenuService{

  override def getUserMenuList(userId: Long): util.List[SysMenuVo] = {
    getMenuList(null)
  }

  def getMenuList(list: util.List[Long]): util.List[SysMenuVo] = {
    val menuList = sysMenuMapper.getMenuList(list)
    val menuMap: util.Map[lang.Long, util.List[SysMenuVo]] = menuList.stream().map(x => {
      //TODO 后面要用mapstruct
      val sysMenuVo = new SysMenuVo()
      BeanUtils.copyProperties(x, sysMenuVo)
      sysMenuVo
    }).collect(Collectors.groupingBy((x: SysMenuVo) => x.getParentId))
    val parentList = menuMap.get(0L)
    fillChildrenMenu(parentList, menuMap)
    parentList
  }

  def fillChildrenMenu(list: util.List[SysMenuVo], map: util.Map[lang.Long, util.List[SysMenuVo]]): Unit = {
    if (CollUtil.isEmpty(list)){
      return
    }
    list.forEach(x => {
      val children = map.get(x.getId)
      fillChildrenMenu(children, map)
      x.setChildren(children)
    })
  }
}
