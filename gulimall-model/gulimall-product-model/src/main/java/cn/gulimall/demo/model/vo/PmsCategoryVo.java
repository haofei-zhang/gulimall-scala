package cn.gulimall.demo.model.vo;

import lombok.Data;

import java.util.List;

/**
 * @author Z
 * @since 2024/7/3 下午11:44
 */
@Data
public class PmsCategoryVo {

    /**
     * 分类id
     */
    private Long catId;

    /**
     * 父分类id
     */
    private Long parentCid;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 层级
     */
    private Integer catLevel;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图标地址
     */
    private String icon;

    /**
     * 计量单位
     */
    private String productUnit;

    /**
     * 商品数量
     */
    private Integer productCount;

    /**
     * 子分类
     */
    private List<PmsCategoryVo> children;

}
