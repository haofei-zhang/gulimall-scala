package cn.gulimall.demo.model.dto;

import lombok.Data;

/**
 * @author Z
 * @since 2024/8/3 下午11:57
 */
@Data
public class PmsCategoryDto {
    /**
     * 分类id
     */
    private Integer catId;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 父分类id
     */
    private Integer parentCid;

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
}
