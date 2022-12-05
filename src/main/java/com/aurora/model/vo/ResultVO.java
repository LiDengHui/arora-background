package com.aurora.model.vo;

import com.aurora.enums.StatusCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.aurora.enums.StatusCodeEnum.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {
    private Boolean flag;

    private Integer code;

    private String message;

    private T data;

    public static <T> ResultVO<T> ok () {
        return resultVo(true, SUCCESS.getCode(), SUCCESS.getDesc(), null);
    }

    public static <T> ResultVO<T> ok (T data) {
        return resultVo(true, SUCCESS.getCode(), SUCCESS.getDesc(), data);
    }

    public static <T> ResultVO<T> ok (T data, String message) {
        return resultVo(true, SUCCESS.getCode(), message, data);
    }

    public static <T> ResultVO<T> fail() {
        return resultVo(false, FAIL.getCode(), FAIL.getDesc(), null);
    }
    public static <T> ResultVO<T> fail(StatusCodeEnum statusCodeEnum) {
        return resultVo(false, statusCodeEnum.getCode(), statusCodeEnum.getDesc(), null);
    }
    public static <T> ResultVO<T> fail(String message) {
        return resultVo(false, message);
    }
    public static <T> ResultVO<T> fail(T data) {
        return resultVo(false, FAIL.getCode(), FAIL.getDesc(), data);
    }

    public static <T> ResultVO<T> fail(T data, String message) {
        return resultVo(false, FAIL.getCode(), message, data);
    }

    public static <T> ResultVO<T> fail(Integer code, String message) {
        return resultVo(false, code, message, null);
    }

    private static <T> ResultVO<T> resultVo(Boolean flag, String message) {
        return ResultVO.<T>builder()
                .flag(flag)
                .code(flag ? SUCCESS.getCode(): FAIL.getCode())
                .message(message).build();
    }

    private static <T> ResultVO<T> resultVo(Boolean flag, Integer code, String message, T data) {
        return ResultVO.<T>builder()
                .flag(flag)
                .code(code)
                .message(message)
                .data(data).build();
    }
}
