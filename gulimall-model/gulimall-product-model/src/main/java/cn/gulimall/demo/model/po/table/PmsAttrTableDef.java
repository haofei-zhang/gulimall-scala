package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * 商品属性 表定义层。
 *
 * @author Z
 * @since 2025-09-04
 */
public class PmsAttrTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 商品属性
     */
    public static final PmsAttrTableDef PMS_ATTR = new PmsAttrTableDef();

    /**
     * 属性图标
     */
    public final QueryColumn ICON = new QueryColumn(this, "icon");

    /**
     * 属性id
     */
    public final QueryColumn ATTR_ID = new QueryColumn(this, "attr_id");

    /**
     * 启用状态[0 - 禁用，1 - 启用]
     */
    public final QueryColumn ENABLE = new QueryColumn(this, "enable");

    /**
     * 属性名
     */
    public final QueryColumn ATTR_NAME = new QueryColumn(this, "attr_name");

    /**
     * 属性类型[0-销售属性，1-基本属性
     */
    public final QueryColumn ATTR_TYPE = new QueryColumn(this, "attr_type");

    /**
     * 快速展示【是否展示在介绍上；0-否 1-是】，在sku中仍然可以调整
     */
    public final QueryColumn SHOW_DESC = new QueryColumn(this, "show_desc");

    /**
     * 所属分类
     */
    public final QueryColumn CATELOG_ID = new QueryColumn(this, "catelog_id");

    /**
     * 值类型[0-为单个值，1-可以选择多个值]
     */
    public final QueryColumn VALUE_TYPE = new QueryColumn(this, "value_type");

    /**
     * 是否需要检索[0-不需要，1-需要]
     */
    public final QueryColumn SEARCH_TYPE = new QueryColumn(this, "search_type");

    /**
     * 可选值列表[用逗号分隔]
     */
    public final QueryColumn VALUE_SELECT = new QueryColumn(this, "value_select");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ATTR_ID, ATTR_NAME, SEARCH_TYPE, VALUE_TYPE, ICON, VALUE_SELECT, ATTR_TYPE, ENABLE, CATELOG_ID, SHOW_DESC};

    public PmsAttrTableDef() {
        super("", "pms_attr");
    }

    private PmsAttrTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PmsAttrTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PmsAttrTableDef("", "pms_attr", alias));
    }

}
