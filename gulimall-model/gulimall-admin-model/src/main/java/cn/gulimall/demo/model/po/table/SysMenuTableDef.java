package cn.gulimall.demo.model.po.table;

import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.table.TableDef;

import java.io.Serial;

/**
 * 菜单管理 表定义层。
 *
 * @author Z
 * @since 2024-05-18
 */
public class SysMenuTableDef extends TableDef {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 菜单管理
     */
    public static final SysMenuTableDef SYS_MENU = new SysMenuTableDef();

    
    public final QueryColumn ID = new QueryColumn(this, "id");

    /**
     * 菜单URL
     */
    public final QueryColumn URL = new QueryColumn(this, "url");

    /**
     * 菜单图标
     */
    public final QueryColumn ICON = new QueryColumn(this, "icon");

    /**
     * 菜单名称
     */
    public final QueryColumn NAME = new QueryColumn(this, "name");

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    public final QueryColumn TYPE = new QueryColumn(this, "type");

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    public final QueryColumn PERMS = new QueryColumn(this, "perms");

    /**
     * 排序
     */
    public final QueryColumn ORDER_NUM = new QueryColumn(this, "order_num");

    /**
     * 父菜单ID，一级菜单为0
     */
    public final QueryColumn PARENT_ID = new QueryColumn(this, "parent_id");

    /**
     * 所有字段。
     */
    public final QueryColumn ALL_COLUMNS = new QueryColumn(this, "*");

    /**
     * 默认字段，不包含逻辑删除或者 large 等字段。
     */
    public final QueryColumn[] DEFAULT_COLUMNS = new QueryColumn[]{ID, PARENT_ID, NAME, URL, PERMS, TYPE, ICON, ORDER_NUM};

    public SysMenuTableDef() {
        super("", "sys_menu");
    }

    private SysMenuTableDef(String schema, String name, String alisa) {
        super(schema, name, alisa);
    }

    public SysMenuTableDef as(String alias) {
        String key = getNameWithSchema() + "." + alias;
        return TableDef.getCache(key, k -> new SysMenuTableDef("", "sys_menu", alias));
    }

}
