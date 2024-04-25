package com.example.common.base;

import com.example.common.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO<T> {
    private Integer code;

    private String msg;

    private T data;

    public static boolean isNotOk(ResultVO<?> result) {
        return !isOk(result);
    }

    public static boolean isOk(ResultVO<?> result) {
        return Objects.equals(ResultEnum.SUCCESS.getCode(), result.getCode());
    }
}