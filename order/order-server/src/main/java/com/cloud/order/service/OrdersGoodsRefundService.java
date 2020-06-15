package com.cloud.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.order.entity.OrdersGoodsRefundEntity;

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
}
