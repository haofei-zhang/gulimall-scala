package cn.gulimall.search.model.po;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author zhanghaofei
 * Create at 2025/9/4
 */
@Data
public class SkuEsModel {

    private Long skuId;

    private Long spuId;

    private String skuTitle;

    private BigDecimal skuPrice;

    private String skuImg;

    private Long saleCount;

    private Boolean hasStock;

    private Long hotStack;

    private Long brandId;

    private Long catalogId;

    private String branName;

    private String calalogName;

    private List<Attrs> attrs;

    @Data
    public static class Attrs {

        private Long attrId;

        private String attrName;

        private String attrValue;

    }


}
