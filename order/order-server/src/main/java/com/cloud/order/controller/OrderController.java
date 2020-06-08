package com.cloud.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述
 *
 * @author wxf
 * @date 2020/6/7 11:19
 */
@RestController
@Slf4j
public class OrderController {
    /**
     * feign 测试调用接口
     * @auther: wxf
     * @date: 2020/6/7 11:47
     */
    @GetMapping("feign/test")
    public void feignTest() {
        log.info("feign调用order接口成功");
    }
}
