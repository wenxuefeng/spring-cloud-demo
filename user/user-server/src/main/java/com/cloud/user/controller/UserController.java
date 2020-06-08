package com.cloud.user.controller;

import com.cloud.common.util.Result;
import com.cloud.order.feign.OrderFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述
 *
 * @author wxf
 * @date 2020/6/7 12:54
 */
@RestController
public class UserController {
    @Resource
    OrderFeignClient orderFeignClient;
    @GetMapping("/test")
    public Result<String> test() {
        orderFeignClient.feignTest();
        return Result.succ("test");
    }
}
