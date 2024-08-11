package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * sku信息 表定义层。
 *
 * @author Z
 * @since 2024-08-12
 */
public class PmsSkuInfoTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * sku信息
     */
    public static final PmsSkuInfoTableDef PMS_SKU_INFO = new PmsSkuInfoTableDef();

    /**
     * 价格
     */
    public final QueryColumn PRICE = new QueryColumn(this, "price");

    /**
     * skuId
     */
    public final QueryColumn SKU_ID = new QueryColumn(this, "sku_id");

    /**
     * spuId
     */
    public final QueryColumn SPU_ID = new QueryColumn(this, "spu_id");

    /**
     * 品牌id
     */
    public final QueryColumn BRAND_ID = new QueryColumn(this, "brand_id");

    /**
     * sku介绍描述
     */
    public final QueryColumn SKU_DESC = new QueryColumn(this, "sku_desc");

    /**
     * sku名称
     */
    public final QueryColumn SKU_NAME = new QueryColumn(this, "sku_name");

    /**
     * 标题
     */
    public final QueryColumn SKU_TITLE = new QueryColumn(this, "sku_title");

    /**
     * 所属分类id
     */
    public final QueryColumn CATALOG_ID = new QueryColumn(this, "catalog_id");

    /**
     * 销量
     */
    public final QueryColumn SALE_COUNT = new QueryColumn(this, "sale_count");

    /**
     * 副标题
     */
    public final QueryColumn SKU_SUBTITLE = new QueryColumn(this, "sku_subtitle");

    /**
     * 默认图片
     */
    public final QueryColumn SKU_DEFAULT_IMG = new QueryColumn(this, "sku_default_img");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{SKU_ID, SPU_ID, SKU_NAME, SKU_DESC, CATALOG_ID, BRAND_ID, SKU_DEFAULT_IMG, SKU_TITLE, SKU_SUBTITLE, PRICE, SALE_COUNT};

    public PmsSkuInfoTableDef() {
        super("", "pms_sku_info");
    }

    private PmsSkuInfoTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PmsSkuInfoTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PmsSkuInfoTableDef("", "pms_sku_info", alias));
    }

}
