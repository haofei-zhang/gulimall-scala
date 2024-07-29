package cn.gulimall.demo.model.po;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

/**
 * 商品三级分类 实体类。
 *
 * @author Z
 * @since 2024-07-28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("pms_category")
public class PmsCategory implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 分类id
     */
    @Id(keyType = KeyType.Auto)
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
     * 层级
     */
    private Integer catLevel;

    /**
     * 是否显示[0-不显示，1显示]
     */
    private Boolean showStatus;

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
