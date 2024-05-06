package cn.gulimall.demo.model.vo;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Z
 */
@Getter
@RequiredArgsConstructor
public enum ResultError implements IResultError{

    OK(200, "OK"),
    ERROR(500, "ERROR"),
    NOT_FOUND(404, "NOT_FOUND"),
    BAD_REQUEST(400, "BAD_REQUEST"),
    UNAUTHORIZED(401, "UNAUTHORIZED"),
    FORBIDDEN(403, "FORBIDDEN"),
    NOT_ACCEPTABLE(406, "NOT_ACCEPTABLE"),
    CONFLICT(409, "CONFLICT"),
    UNSUPPORTED_MEDIA_TYPE(415,"UNSUPPORTED_MEDIA_TYPE"),
    ;

    private final Integer code;
    private final String msg;

}
