package com.cloud.order.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.order.dao.OrdersGoodsRefundMapper;
import com.cloud.order.entity.OrdersGoodsRefundEntity;
import com.cloud.order.feign.dto.OrdersGoodsRefundDTO;
import com.cloud.order.service.OrdersGoodsRefundService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author wxf
 * @date 2020/6/11 17:49
 * @description 简单描述
 **/
@Service
@Slf4j
public class OrdersGoodsRefundServiceImpl extends ServiceImpl<OrdersGoodsRefundMapper, OrdersGoodsRefundEntity>
        implements OrdersGoodsRefundService {

    /**
     * 退款
     *
     * @author: wxf
     * @date: 2020/6/12 11:42
     * @return: {@link String}
     * @version 1.1.0
     **/
    @Override
    @GlobalTransactional(name = "order-refund", rollbackFor = Exception.class)
    public String orderRefund() {
        OrdersGoodsRefundDTO dto = new OrdersGoodsRefundDTO();
        dto.setId(IdWorker.getId())
                .setRefundId(IdWorker.getId())
                .setRefundNumber("123456")
                .setOrderGoodsId(IdWorker.getId())
                .setNumber(1)
                .setPrice(new BigDecimal(30));
        OrdersGoodsRefundEntity entity = new OrdersGoodsRefundEntity();
        BeanUtils.copyProperties(dto, entity);
        this.save(entity);
        return "退款成功";
    }
}
