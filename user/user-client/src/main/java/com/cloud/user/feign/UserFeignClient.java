package com.cloud.user.feign;

import com.cloud.common.constant.ServerConstant;
import com.cloud.common.util.Result;
import com.cloud.user.feign.impl.UserFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    /**
     * 用户订单退款
     *
     * @author: wxf
     * @date: 2020/6/12 11:50
     * @param status 1-表示抛异常回滚
     * @return: {@link Result< String>}
     **/
    @GetMapping("/orderRefund/{status}")
    Result<String> userOrderRefund(@PathVariable Integer status);
}
