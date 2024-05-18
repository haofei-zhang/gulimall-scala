package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * 用户与角色对应关系 表定义层。
 *
 * @author Z
 * @since 2024-05-18
 */
public class SysUserRoleTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户与角色对应关系
     */
    public static final SysUserRoleTableDef SYS_USER_ROLE = new SysUserRoleTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 角色ID
     */
    public final QueryColumn ROLE_ID = new QueryColumn(this, "role_id");

    /**
     * 用户ID
     */
    public final QueryColumn USER_ID = new QueryColumn(this, "user_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, USER_ID, ROLE_ID};

    public SysUserRoleTableDef() {
        super("", "sys_user_role");
    }

    private SysUserRoleTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public SysUserRoleTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return TableDef.getCache(key, k -> new SysUserRoleTableDef("", "sys_user_role", alias));
    }

}
