package cn.gulimall.demo.model.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Z
 */
@Getter
@RequiredArgsConstructor
public enum ResultError implements IResultError{

    OK(0, "OK"),
    ERROR(10000, "ERROR"),
    UNAUTHORIZED(20000, "UNAUTHORIZED")
    ;

    private final Integer code;
    private final String msg;

}
