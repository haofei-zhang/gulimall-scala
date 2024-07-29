package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * 商品三级分类 表定义层。
 *
 * @author Z
 * @since 2024-07-28
 */
public class PmsCategoryTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 商品三级分类
     */
    public static final PmsCategoryTableDef PMS_CATEGORY = new PmsCategoryTableDef();

    /**
     * 图标地址
     */
    public final QueryColumn ICON = new QueryColumn(this, "icon");

    /**
     * 分类名称
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 排序
     */
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    /**
     * 分类id
     */
    public final QueryColumn CAT_ID = new QueryColumn(this, "cat_id");

    /**
     * 层级
     */
    public final QueryColumn CAT_LEVEL = new QueryColumn(this, "cat_level");

    /**
     * 父分类id
     */
    public final QueryColumn PARENT_CID = new QueryColumn(this, "parent_cid");

    /**
     * 是否显示[0-不显示，1显示]
     */
    public final QueryColumn SHOW_STATUS = new QueryColumn(this, "show_status");

    /**
     * 计量单位
     */
    public final QueryColumn PRODUCT_UNIT = new QueryColumn(this, "product_unit");

    /**
     * 商品数量
     */
    public final QueryColumn PRODUCT_COUNT = new QueryColumn(this, "product_count");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{CAT_ID, NAME, PARENT_CID, CAT_LEVEL, SHOW_STATUS, SORT, ICON, PRODUCT_UNIT, PRODUCT_COUNT};

    public PmsCategoryTableDef() {
        super("", "pms_category");
    }

    private PmsCategoryTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PmsCategoryTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PmsCategoryTableDef("", "pms_category", alias));
    }

}
