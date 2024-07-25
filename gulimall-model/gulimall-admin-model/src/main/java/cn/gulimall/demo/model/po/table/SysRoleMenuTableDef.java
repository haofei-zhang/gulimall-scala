package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * 角色与菜单对应关系 表定义层。
 *
 * @author Z
 * @since 2024-07-26
 */
public class SysRoleMenuTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 角色与菜单对应关系
     */
    public static final SysRoleMenuTableDef SYS_ROLE_MENU = new SysRoleMenuTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 菜单ID
     */
    public final QueryColumn MENU_ID = new QueryColumn(this, "menu_id");

    /**
     * 角色ID
     */
    public final QueryColumn ROLE_ID = new QueryColumn(this, "role_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, ROLE_ID, MENU_ID};

    public SysRoleMenuTableDef() {
        super("", "sys_role_menu");
    }

    private SysRoleMenuTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public SysRoleMenuTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return getCache(key, k -> new SysRoleMenuTableDef("", "sys_role_menu", alias));
    }

}
