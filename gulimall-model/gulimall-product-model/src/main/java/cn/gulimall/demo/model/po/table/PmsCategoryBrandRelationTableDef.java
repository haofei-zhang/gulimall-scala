package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * 品牌分类关联 表定义层。
 *
 * @author Z
 * @since 2024-08-12
 */
public class PmsCategoryBrandRelationTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 品牌分类关联
     */
    public static final PmsCategoryBrandRelationTableDef PMS_CATEGORY_BRAND_RELATION = new PmsCategoryBrandRelationTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 品牌id
     */
    public final QueryColumn BRAND_ID = new QueryColumn(this, "brand_id");

    
    public final QueryColumn BRAND_NAME = new QueryColumn(this, "brand_name");

    /**
     * 分类id
     */
    public final QueryColumn CATELOG_ID = new QueryColumn(this, "catelog_id");

    
    public final QueryColumn CATELOG_NAME = new QueryColumn(this, "catelog_name");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, BRAND_ID, CATELOG_ID, BRAND_NAME, CATELOG_NAME};

    public PmsCategoryBrandRelationTableDef() {
        super("", "pms_category_brand_relation");
    }

    private PmsCategoryBrandRelationTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PmsCategoryBrandRelationTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PmsCategoryBrandRelationTableDef("", "pms_category_brand_relation", alias));
    }

}
