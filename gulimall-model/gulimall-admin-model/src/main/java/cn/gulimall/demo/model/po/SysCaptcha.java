package cn.gulimall.demo.model.po;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serial;

/**
 * 系统验证码 实体类。
 *
 * @author Z
 * @since 2024-05-18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table("sys_captcha")
public class SysCaptcha implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * uuid
     */
    @Id
    private String uuid;

    /**
     * 验证码
     */
    private String code;

    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

}
