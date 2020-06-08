package com.cloud.common.util;

import com.cloud.common.exception.ErrorCode;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 统一接口返回数据类型
 *
 * @author wxf
 * @date 2020/6/7 11:52
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 编码：0表示成功，其他值表示失败
     */
    @ApiModelProperty(value = "编码：0表示成功，其他值表示失败")
    private int code = 0;
    /**
     * 消息内容
     */
    @ApiModelProperty(value = "消息内容")
    private String msg = "success";
    /**
     * 响应数据
     */
    @ApiModelProperty(value = "响应数据")
    private T data;

    public Result<T> ok(T data) {
        this.setData(data);
        return this;
    }

    public boolean success() {
        return code == 0;
    }

    public boolean failure() {
        return code != 0;
    }


    public Result<T> error(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public Result<T> error(String msg) {
        this.code = ErrorCode.INTERNAL_SERVER_ERROR;
        this.msg = msg;
        return this;
    }

    /**
     * 成功返回
     *
     * @param <T> 返回类型
     * @return Result
     */
    public static <T> Result<T> succ() {
        return new Result<T>().ok(null);
    }

    /**
     * 成功返回
     *
     * @param <T>  返回类型
     * @param data 返回结果
     * @return Result
     */
    public static <T> Result<T> succ(T data) {
        return new Result<T>().ok(data);
    }


    /**
     * 失败返回
     *
     * @param <T> 返回类型
     * @param msg 失败错误提示
     * @return Result
     */
    public static <T> Result<T> fail(String msg) {
        return new Result<T>().error(msg);
    }

    /**
     * 失败返回
     *
     * @param <T>  返回类型
     * @param code 失败错误码
     * @param msg  失败错误提示
     * @return Result
     */
    public static <T> Result<T> fail(int code, String msg) {
        return new Result<T>().error(code, msg);
    }
}

