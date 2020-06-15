package com.cloud.front.admin.controller.user;

import com.cloud.common.util.Result;
import com.cloud.user.feign.UserFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述
 *
 * @author wxf
 * @date 2020/6/7 18:24
 */
@RestController
@RequestMapping("/user")
public class AdminUserController {
    @Resource
    UserFeignClient userFeignClient;
    @GetMapping("/test")
    public Result<String> test() {
        return userFeignClient.test();
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
        return userFeignClient.userOrderRefund(status);
    }
}
