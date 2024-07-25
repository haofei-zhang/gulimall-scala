package cn.gulimall.demo.model.po;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 角色 实体类。
 *
 * @author Z
 * @since 2024-07-26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("sys_role")
public class SysRole implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    private Integer roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建者ID
     */
    private Integer insertUser;

    /**
     * 创建时间
     */
    private Timestamp insertTime;

}
