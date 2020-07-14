package com.cloud.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.order.entity.OrdersGoodsRefundEntity;

import java.util.concurrent.Future;

/**
 * @author wxf
 * @date 2020/6/11 17:46
 * @description 简单描述
 **/
public interface OrdersGoodsRefundService extends IService<OrdersGoodsRefundEntity> {
    /**
     * 退款
     *
     * @author: wxf
     * @date: 2020/6/12 11:42
     * @return: {@link String}
     * @version 1.1.0
     **/
    String orderRefund();

    /**
     * 异步方法 异步订单退款
     * @author: wxf
     * @date: 2020/7/11 9:54
     * @version 1.1.0
     **/
    void asyncOrderRefund();
}
