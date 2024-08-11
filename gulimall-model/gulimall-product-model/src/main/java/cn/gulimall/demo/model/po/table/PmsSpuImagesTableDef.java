package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * spu图片 表定义层。
 *
 * @author Z
 * @since 2024-08-12
 */
public class PmsSpuImagesTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * spu图片
     */
    public static final PmsSpuImagesTableDef PMS_SPU_IMAGES = new PmsSpuImagesTableDef();

    /**
     * id
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * spu_id
     */
    public final QueryColumn SPU_ID = new QueryColumn(this, "spu_id");

    /**
     * 图片地址
     */
    public final QueryColumn IMG_URL = new QueryColumn(this, "img_url");

    /**
     * 图片名
     */
    public final QueryColumn IMG_NAME = new QueryColumn(this, "img_name");

    /**
     * 顺序
     */
    public final QueryColumn IMG_SORT = new QueryColumn(this, "img_sort");

    /**
     * 是否默认图
     */
    public final QueryColumn DEFAULT_IMG = new QueryColumn(this, "default_img");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, SPU_ID, IMG_NAME, IMG_URL, IMG_SORT, DEFAULT_IMG};

    public PmsSpuImagesTableDef() {
        super("", "pms_spu_images");
    }

    private PmsSpuImagesTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PmsSpuImagesTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PmsSpuImagesTableDef("", "pms_spu_images", alias));
    }

}
