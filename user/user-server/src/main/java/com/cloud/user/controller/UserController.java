package com.cloud.user.controller;

import com.cloud.common.util.Result;
import com.cloud.order.feign.OrderFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
     * 用户订单退款
     *
     * @author: wxf
     * @date: 2020/6/12 11:50
     * @param status 1-表示抛异常回滚
     * @return: {@link Result< String>}
     **/
    @GetMapping("/orderRefund/{status}")
    public Result<String> userOrderRefund(@PathVariable Integer status) {
        orderFeignClient.orderRefund();
        if (1 == status) {
            throw new RuntimeException("模拟出现异常回滚订单事务回滚");
        }
        return Result.succ("用户退款成功");
    }
}
