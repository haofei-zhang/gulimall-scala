package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * sku图片 表定义层。
 *
 * @author Z
 * @since 2024-08-12
 */
public class PmsSkuImagesTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * sku图片
     */
    public static final PmsSkuImagesTableDef PMS_SKU_IMAGES = new PmsSkuImagesTableDef();

    /**
     * id
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * sku_id
     */
    public final QueryColumn SKU_ID = new QueryColumn(this, "sku_id");

    /**
     * 图片地址
     */
    public final QueryColumn IMG_URL = new QueryColumn(this, "img_url");

    /**
     * 排序
     */
    public final QueryColumn IMG_SORT = new QueryColumn(this, "img_sort");

    /**
     * 默认图[0 - 不是默认图，1 - 是默认图]
     */
    public final QueryColumn DEFAULT_IMG = new QueryColumn(this, "default_img");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, SKU_ID, IMG_URL, IMG_SORT, DEFAULT_IMG};

    public PmsSkuImagesTableDef() {
        super("", "pms_sku_images");
    }

    private PmsSkuImagesTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PmsSkuImagesTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PmsSkuImagesTableDef("", "pms_sku_images", alias));
    }

}
