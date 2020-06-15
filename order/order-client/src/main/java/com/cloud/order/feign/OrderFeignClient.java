package com.cloud.order.feign;

import com.cloud.common.constant.ServerConstant;
import com.cloud.common.util.Result;
import com.cloud.order.feign.impl.OderFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * oder服务内部调用接口
 *
 * @author wxf
 * @date 2020/6/7 10:46
 */
@FeignClient(name = ServerConstant.ORDER_SERVER, path = "/order",
             fallbackFactory = OderFeignClientFallback.class)
public interface OrderFeignClient {
    /**
     * feign 测试调用接口
     * @auther: wxf
     * @date: 2020/6/7 11:47
     */
    @GetMapping("feign/test")
    void feignTest();

    /**
     * 退款
     *
     * @author: wxf
     * @date: 2020/6/11 18:04
     * @return: {@link Result < String>}
     **/
    @GetMapping("orderRefund")
    Result<String> orderRefund();
}
