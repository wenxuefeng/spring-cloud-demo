package com.cloud.common.exception;

/**
 * 错误编码，由5位数字组成，前2位为模块编码，后3位为业务编码
 * 如：10001（10代表系统模块，001代表业务代码）
 * @author wxf
 * @date 2020/6/7 11:56
 */
public interface ErrorCode {
    int INTERNAL_SERVER_ERROR = 500;
}
