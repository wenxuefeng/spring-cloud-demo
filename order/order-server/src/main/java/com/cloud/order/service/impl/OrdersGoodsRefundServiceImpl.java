package com.cloud.order.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.order.dao.OrdersGoodsRefundMapper;
import com.cloud.order.entity.OrdersGoodsRefundEntity;
import com.cloud.order.feign.dto.OrdersGoodsRefundDTO;
import com.cloud.order.service.OrdersGoodsRefundService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.Resource;
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
    @Resource
    private DataSourceTransactionManager transactionManager;
    /**
     * 退款
     *
     * @author: wxf
     * @date: 2020/6/12 11:42
     * @return: {@link String}
     * @version 1.1.0
     **/
    @Override
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

    /**
     * 异步方法 异步订单退款
     * @author: wxf
     * @date: 2020/7/11 9:54
     * @version 1.1.0
     **/
    @Override
    @Async
    public void asyncOrderRefund() {
        log.info("开始执行异步订单退款业务 ----------------------");
        try {
            OrdersGoodsRefundEntity entity = new OrdersGoodsRefundEntity();
            entity.setId(IdWorker.getId())
                    .setRefundId(IdWorker.getId())
                    .setRefundNumber("123456")
                    .setOrderGoodsId(IdWorker.getId())
                    .setNumber(1)
                    .setPrice(new BigDecimal(30));
            asyncSaveOrderRefund(entity);
        } catch (Exception e) {
            log.error("执行业务出现异常", e);
        }
    }

    private void asyncSaveOrderRefund(OrdersGoodsRefundEntity entity) {
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        // 发起一个新的事物
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            Thread.sleep(3000);
            this.save(entity);
            log.debug("异步保存退款订单成功");
            // 提交
            transactionManager.commit(status);
        } catch (Exception e) {
           // 回滚
            transactionManager.rollback(status);
        }
    }
}
