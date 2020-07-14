package com.cloud.order.controller;

import com.cloud.common.util.Result;
import com.cloud.order.service.OrdersGoodsRefundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 描述
 *
 * @author wxf
 * @date 2020/6/7 11:19
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    OrdersGoodsRefundService ordersGoodsRefundService;
    /**
     * feign 测试调用接口
     * @auther: wxf
     * @date: 2020/6/7 11:47
     */
    @GetMapping("feign/test")
    public void feignTest() {
        log.info("feign调用order接口成功");
    }

    /**
     * 退款
     *
     * @author: wxf
     * @date: 2020/6/11 18:04
     * @return: {@link Result< String>}
     **/
    @GetMapping("orderRefund")
    public Result<String> orderRefund() {
        return Result.succ(ordersGoodsRefundService.orderRefund());
    }

    /**
     * 异步方法 异步订单退款
     * 返回 true 退款成功 false 退款失败
     * @author: wxf
     * @date: 2020/7/11 9:54
     * @return: {@link boolean}
     * @version 1.1.0
     **/
    @GetMapping("asyncOrderRefund")
    public Result<String> asyncOrderRefund() {
        ordersGoodsRefundService.asyncOrderRefund();
        return Result.succ("退款成功");
    }
}
