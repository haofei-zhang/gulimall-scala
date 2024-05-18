package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * 系统用户 表定义层。
 *
 * @author Z
 * @since 2024-05-14
 */
public class SysUserTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 系统用户
     */
    public static final SysUserTableDef SYS_USER = new SysUserTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 盐
     */
    public final QueryColumn SALT = new QueryColumn(this, "salt");

    /**
     * 邮箱
     */
    public final QueryColumn EMAIL = new QueryColumn(this, "email");

    /**
     * 手机号
     */
    public final QueryColumn MOBILE = new QueryColumn(this, "mobile");

    /**
     * 状态  0：禁用   1：正常
     */
    public final QueryColumn STATUS = new QueryColumn(this, "status");

    /**
     * 密码
     */
    public final QueryColumn PASSWORD = new QueryColumn(this, "password");

    /**
     * 用户名
     */
    public final QueryColumn USERNAME = new QueryColumn(this, "username");

    /**
     * 创建时间
     */
    public final QueryColumn CREATE_TIME = new QueryColumn(this, "create_time");

    /**
     * 创建者ID
     */
    public final QueryColumn CREATE_USER_ID = new QueryColumn(this, "create_user_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, USERNAME, PASSWORD, SALT, EMAIL, MOBILE, STATUS, CREATE_USER_ID, CREATE_TIME};

    public SysUserTableDef() {
        super("", "sys_user");
    }

    private SysUserTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public SysUserTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return TableDef.getCache(key, k -> new SysUserTableDef("", "sys_user", alias));
    }

}
