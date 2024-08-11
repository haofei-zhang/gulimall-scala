package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * sku销售属性&值 表定义层。
 *
 * @author Z
 * @since 2024-08-12
 */
public class PmsSkuSaleAttrValueTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * sku销售属性&值
     */
    public static final PmsSkuSaleAttrValueTableDef PMS_SKU_SALE_ATTR_VALUE = new PmsSkuSaleAttrValueTableDef();

    /**
     * id
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * sku_id
     */
    public final QueryColumn SKU_ID = new QueryColumn(this, "sku_id");

    /**
     * attr_id
     */
    public final QueryColumn ATTR_ID = new QueryColumn(this, "attr_id");

    /**
     * 销售属性名
     */
    public final QueryColumn ATTR_NAME = new QueryColumn(this, "attr_name");

    /**
     * 顺序
     */
    public final QueryColumn ATTR_SORT = new QueryColumn(this, "attr_sort");

    /**
     * 销售属性值
     */
    public final QueryColumn ATTR_VALUE = new QueryColumn(this, "attr_value");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, SKU_ID, ATTR_ID, ATTR_NAME, ATTR_VALUE, ATTR_SORT};

    public PmsSkuSaleAttrValueTableDef() {
        super("", "pms_sku_sale_attr_value");
    }

    private PmsSkuSaleAttrValueTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PmsSkuSaleAttrValueTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PmsSkuSaleAttrValueTableDef("", "pms_sku_sale_attr_value", alias));
    }

}
