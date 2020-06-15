package com.cloud.order.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.cloud.common.util.Result;
import com.cloud.order.entity.OrdersGoodsRefundEntity;
import com.cloud.order.feign.dto.OrdersGoodsRefundDTO;
import com.cloud.order.service.OrdersGoodsRefundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;

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
}
