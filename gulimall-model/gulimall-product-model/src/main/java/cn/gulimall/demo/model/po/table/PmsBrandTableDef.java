package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * 品牌 表定义层。
 *
 * @author Z
 * @since 2024-08-13
 */
public class PmsBrandTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 品牌
     */
    public static final PmsBrandTableDef PMS_BRAND = new PmsBrandTableDef();

    
    public final QueryColumn DEL = new QueryColumn(this, "del");

    /**
     * 品牌logo地址
     */
    public final QueryColumn LOGO = new QueryColumn(this, "logo");

    /**
     * 品牌名
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 排序
     */
    public final QueryColumn SORT = new QueryColumn(this, "sort");

    /**
     * 品牌id
     */
    public final QueryColumn BRAND_ID = new QueryColumn(this, "brand_id");

    /**
     * 介绍
     */
    public final QueryColumn DESCRIPT = new QueryColumn(this, "descript");

    /**
     * 检索首字母
     */
    public final QueryColumn FIRST_LETTER = new QueryColumn(this, "first_letter");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{BRAND_ID, NAME, LOGO, DESCRIPT, FIRST_LETTER, SORT, DEL};

    public PmsBrandTableDef() {
        super("", "pms_brand");
    }

    private PmsBrandTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PmsBrandTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PmsBrandTableDef("", "pms_brand", alias));
    }

}
