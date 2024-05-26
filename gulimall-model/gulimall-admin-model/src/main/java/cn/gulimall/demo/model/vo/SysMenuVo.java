package cn.gulimall.demo.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Z
 * @since 2024/5/21 下午11:10
 */
@Data
public class SysMenuVo {

    private Long id;

    /**
     * 父菜单ID，一级菜单为0
     */
    private Long parentId;

    /**
     * 父菜单名称
     */
    private String parentName;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;

    /**
     * 类型     0：目录   1：菜单   2：按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 子菜单
     */
    private List<SysMenuVo> children;

}
