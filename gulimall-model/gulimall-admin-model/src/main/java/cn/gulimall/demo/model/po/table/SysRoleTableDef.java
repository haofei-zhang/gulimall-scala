package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * 角色 表定义层。
 *
 * @author Z
 * @since 2024-05-18
 */
public class SysRoleTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 角色
     */
    public static final SysRoleTableDef SYS_ROLE = new SysRoleTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 备注
     */
    public final QueryColumn REMARK = new QueryColumn(this, "remark");

    /**
     * 角色名称
     */
    public final QueryColumn ROLE_NAME = new QueryColumn(this, "role_name");

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
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ROLE_NAME, REMARK, CREATE_USER_ID, CREATE_TIME};

    public SysRoleTableDef() {
        super("", "sys_role");
    }

    private SysRoleTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public SysRoleTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return TableDef.getCache(key, k -> new SysRoleTableDef("", "sys_role", alias));
    }

}
