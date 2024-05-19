package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * 系统验证码 表定义层。
 *
 * @author Z
 * @since 2024-05-18
 */
public class SysCaptchaTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统验证码
     */
    public static final SysCaptchaTableDef SYS_CAPTCHA = new SysCaptchaTableDef();

    /**
     * 验证码
     */
    public final QueryColumn CODE = new QueryColumn(this, "code");

    /**
     * uuid
     */
    public final QueryColumn UUID = new QueryColumn(this, "uuid");

    /**
     * 过期时间
     */
    public final QueryColumn EXPIRE_TIME = new QueryColumn(this, "expire_time");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{UUID, CODE, EXPIRE_TIME};

    public SysCaptchaTableDef() {
        super("", "sys_captcha");
    }

    private SysCaptchaTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public SysCaptchaTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new SysCaptchaTableDef("", "sys_captcha", alias));
    }

}
