package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * 商品评价回复关系 表定义层。
 *
 * @author Z
 * @since 2024-08-12
 */
public class PmsCommentReplayTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 商品评价回复关系
     */
    public static final PmsCommentReplayTableDef PMS_COMMENT_REPLAY = new PmsCommentReplayTableDef();

    /**
     * id
     */
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 回复id
     */
    public final QueryColumn REPLY_ID = new QueryColumn(this, "reply_id");

    /**
     * 评论id
     */
    public final QueryColumn COMMENT_ID = new QueryColumn(this, "comment_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, COMMENT_ID, REPLY_ID};

    public PmsCommentReplayTableDef() {
        super("", "pms_comment_replay");
    }

    private PmsCommentReplayTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public PmsCommentReplayTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new PmsCommentReplayTableDef("", "pms_comment_replay", alias));
    }

}
