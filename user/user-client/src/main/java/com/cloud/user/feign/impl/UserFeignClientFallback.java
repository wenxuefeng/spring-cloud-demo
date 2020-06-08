package com.cloud.user.feign.impl;

import com.cloud.common.util.Result;
import com.cloud.user.feign.UserFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 描述
 *
 * @author wxf
 * @date 2020/6/7 18:18
 */
@Component
public class UserFeignClientFallback implements FallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {

            @Override
            public Result<String> test() {
                return Result.fail("调用user/test接口失败");
            }
        };
    }
}
