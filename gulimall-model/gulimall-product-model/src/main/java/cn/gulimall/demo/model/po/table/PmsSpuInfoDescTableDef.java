package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * spu信息介绍 表定义层。
 *
 * @author Z
 * @since 2024-08-12
 */
public class PmsSpuInfoDescTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * spu信息介绍
     */
    public static final PmsSpuInfoDescTableDef PMS_SPU_INFO_DESC = new PmsSpuInfoDescTableDef();

    /**
     * 商品id
     */
    public final QueryColumn SPU_ID = new QueryColumn(this, "spu_id");

    /**
     * 商品介绍
     */
    public final QueryColumn DECRIPT = new QueryColumn(this, "decript");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{SPU_ID, DECRIPT};

    public PmsSpuInfoDescTableDef() {
        super("", "pms_spu_info_desc");
    }

    private PmsSpuInfoDescTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PmsSpuInfoDescTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PmsSpuInfoDescTableDef("", "pms_spu_info_desc", alias));
    }

}
