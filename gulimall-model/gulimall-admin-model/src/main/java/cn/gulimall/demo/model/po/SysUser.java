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
 * 系统用户 实体类。
 *
 * @author Z
 * @since 2024-07-26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("sys_user")
public class SysUser implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id(keyType = KeyType.Auto)
    private Integer userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 状态  0：禁用   1：正常
     */
    private Integer status;

    /**
     * 创建者ID
     */
    private Integer insertUser;

    /**
     * 创建时间
     */
    private Timestamp insertTime;

}
