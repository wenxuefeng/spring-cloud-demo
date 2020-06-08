package com.cloud.order.feign.impl;

import com.cloud.order.feign.OrderFeignClient;
import com.cloud.common.util.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 描述
 *
 * @author wxf
 * @date 2020/6/7 11:10
 */
@Component
public class OderFeignClientFallback implements FallbackFactory<OrderFeignClient> {

    @Override
    public OrderFeignClient create(Throwable throwable) {
        return new OrderFeignClient() {
            /**
             * feign 测试调用接口
             *
             * @auther: wxf
             * @date: 2020/6/7 11:47
             */
            @Override
            public void feignTest() {
                Result.fail("调用order/feignTest接口失败");
            }
        };
    }
}
