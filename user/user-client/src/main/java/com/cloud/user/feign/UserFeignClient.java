package com.cloud.user.feign;

import com.cloud.common.constant.ServerConstant;
import com.cloud.common.util.Result;
import com.cloud.user.feign.impl.UserFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 用户服务内部调用接口
 *ø
 * @author wxf
 * @date 2020/6/7 18:16
 */
@FeignClient(value = ServerConstant.USER_SERVER, path = "/user",
        fallbackFactory = UserFeignClientFallback.class)
public interface UserFeignClient {
    @GetMapping("/test")
    Result<String> test();
}
