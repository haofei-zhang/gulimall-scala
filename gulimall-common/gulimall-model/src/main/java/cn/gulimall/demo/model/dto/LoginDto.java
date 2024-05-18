package cn.gulimall.demo.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author Z
 * @since 2024/5/14 下午11:38
 */
@Data
public class LoginDto {

    @NotBlank
    private String mobile;

    @NotBlank
    private String password;

}
