package com.cloud.front.admin.controller.user;

import com.cloud.common.util.Result;
import com.cloud.user.feign.UserFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
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
}
