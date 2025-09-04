package cn.gulimall.admin.converter;

import cn.gulimall.demo.model.po.SysMenu;
import cn.gulimall.demo.model.vo.SysMenuVo;
import cn.hutool.core.collection.CollUtil;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Map;

/**
 * @author zhanghaofei
 * Create at 2025/9/1
 */
@Mapper(componentModel = "spring")
public abstract class MenuConverter {

    /**
     * po 转vo
     *
     * @param sysMenu
     * @return
     */
    @Mappings({
            @Mapping(source = "menuId", target = "menuId"),
            @Mapping(source = "parentId", target = "parentId"),
            @Mapping(target = "parentName", ignore = true),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "url", target = "url"),
            @Mapping(source = "perms", target = "perms"),
            @Mapping(source = "type", target = "type"),
            @Mapping(source = "icon", target = "icon"),
            @Mapping(source = "orderNum", target = "orderNum"),
            @Mapping(target = "children", ignore = true)
    })
    public abstract SysMenuVo toVo(SysMenu sysMenu);

    public void fillChildrenMenu(List<SysMenuVo> list, Map<Integer, List<SysMenuVo>> map){
        if (CollUtil.isEmpty(list)){
            return;
        }
        for (SysMenuVo sysMenuVo : list) {
            List<SysMenuVo> children = map.get(sysMenuVo.getMenuId());
            fillChildrenMenu(children, map);
            sysMenuVo.setChildren(children);
        }
    }

}
