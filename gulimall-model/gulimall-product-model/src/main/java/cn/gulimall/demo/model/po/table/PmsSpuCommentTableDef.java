package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * 商品评价 表定义层。
 *
 * @author Z
 * @since 2024-08-12
 */
public class PmsSpuCommentTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 商品评价
     */
    public static final PmsSpuCommentTableDef PMS_SPU_COMMENT = new PmsSpuCommentTableDef();

    /**
     * id
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    
    public final QueryColumn DEL = new QueryColumn(this, "del");

    /**
     * 星级
     */
    public final QueryColumn STAR = new QueryColumn(this, "star");

    /**
     * sku_id
     */
    public final QueryColumn SKU_ID = new QueryColumn(this, "sku_id");

    /**
     * spu_id
     */
    public final QueryColumn SPU_ID = new QueryColumn(this, "spu_id");

    /**
     * 内容
     */
    public final QueryColumn CONTENT = new QueryColumn(this, "content");

    /**
     * 商品名字
     */
    public final QueryColumn SPU_NAME = new QueryColumn(this, "spu_name");

    /**
     * 会员ip
     */
    public final QueryColumn MEMBER_IP = new QueryColumn(this, "member_ip");

    /**
     * 评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]
     */
    public final QueryColumn RESOURCES = new QueryColumn(this, "resources");

    /**
     * 创建时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 点赞数
     */
    public final QueryColumn LIKES_COUNT = new QueryColumn(this, "likes_count");

    /**
     * 用户头像
     */
    public final QueryColumn MEMBER_ICON = new QueryColumn(this, "member_icon");

    /**
     * 回复数
     */
    public final QueryColumn REPLY_COUNT = new QueryColumn(this, "reply_count");

    /**
     * 评论类型[0 - 对商品的直接评论，1 - 对评论的回复]
     */
    public final QueryColumn COMMENT_TYPE = new QueryColumn(this, "comment_type");

    /**
     * 购买时属性组合
     */
    public final QueryColumn SPU_ATTRIBUTES = new QueryColumn(this, "spu_attributes");

    /**
     * 会员昵称
     */
    public final QueryColumn MEMBER_NICK_NAME = new QueryColumn(this, "member_nick_name");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, SKU_ID, SPU_ID, SPU_NAME, MEMBER_NICK_NAME, STAR, MEMBER_IP, CREATE_TIME, SPU_ATTRIBUTES, LIKES_COUNT, REPLY_COUNT, RESOURCES, CONTENT, MEMBER_ICON, COMMENT_TYPE, DEL};

    public PmsSpuCommentTableDef() {
        super("", "pms_spu_comment");
    }

    private PmsSpuCommentTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PmsSpuCommentTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PmsSpuCommentTableDef("", "pms_spu_comment", alias));
    }

}
