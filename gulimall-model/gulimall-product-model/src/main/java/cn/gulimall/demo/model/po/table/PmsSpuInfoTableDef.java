package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * spu信息 表定义层。
 *
 * @author Z
 * @since 2024-08-12
 */
public class PmsSpuInfoTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * spu信息
     */
    public static final PmsSpuInfoTableDef PMS_SPU_INFO = new PmsSpuInfoTableDef();

    /**
     * 商品id
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn WEIGHT = new QueryColumn(this, "weight");

    /**
     * 品牌id
     */
    public final QueryColumn BRAND_ID = new QueryColumn(this, "brand_id");

    /**
     * 商品名称
     */
    public final QueryColumn SPU_NAME = new QueryColumn(this, "spu_name");

    /**
     * 所属分类id
     */
    public final QueryColumn CATALOG_ID = new QueryColumn(this, "catalog_id");

    
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    
    public final QueryColumn UPDATE_TIME = new QueryColumn(this, "update_time");

    /**
     * 上架状态[0 - 下架，1 - 上架]
     */
    public final QueryColumn PUBLISH_STATUS = new QueryColumn(this, "publish_status");

    /**
     * 商品描述
     */
    public final QueryColumn SPU_DESCRIPTION = new QueryColumn(this, "spu_description");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, SPU_NAME, SPU_DESCRIPTION, CATALOG_ID, BRAND_ID, WEIGHT, PUBLISH_STATUS, CREATE_TIME, UPDATE_TIME};

    public PmsSpuInfoTableDef() {
        super("", "pms_spu_info");
    }

    private PmsSpuInfoTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PmsSpuInfoTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PmsSpuInfoTableDef("", "pms_spu_info", alias));
    }

}
