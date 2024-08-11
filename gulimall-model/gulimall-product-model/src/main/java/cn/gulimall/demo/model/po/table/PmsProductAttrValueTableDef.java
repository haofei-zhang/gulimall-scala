package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * spu属性值 表定义层。
 *
 * @author Z
 * @since 2024-08-12
 */
public class PmsProductAttrValueTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * spu属性值
     */
    public static final PmsProductAttrValueTableDef PMS_PRODUCT_ATTR_VALUE = new PmsProductAttrValueTableDef();

    /**
     * id
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 商品id
     */
    public final QueryColumn SPU_ID = new QueryColumn(this, "spu_id");

    /**
     * 属性id
     */
    public final QueryColumn ATTR_ID = new QueryColumn(this, "attr_id");

    /**
     * 属性名
     */
    public final QueryColumn ATTR_NAME = new QueryColumn(this, "attr_name");

    /**
     * 顺序
     */
    public final QueryColumn ATTR_SORT = new QueryColumn(this, "attr_sort");

    /**
     * 属性值
     */
    public final QueryColumn ATTR_VALUE = new QueryColumn(this, "attr_value");

    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】
     */
    public final QueryColumn QUICK_SHOW = new QueryColumn(this, "quick_show");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, SPU_ID, ATTR_ID, ATTR_NAME, ATTR_VALUE, ATTR_SORT, QUICK_SHOW};

    public PmsProductAttrValueTableDef() {
        super("", "pms_product_attr_value");
    }

    private PmsProductAttrValueTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PmsProductAttrValueTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PmsProductAttrValueTableDef("", "pms_product_attr_value", alias));
    }

}
