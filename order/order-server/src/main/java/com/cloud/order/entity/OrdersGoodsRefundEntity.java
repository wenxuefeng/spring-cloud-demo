package com.cloud.order.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author wxf
 * @date 2020/6/11 16:42
 * @description 简单描述
 **/
@Data
@TableName("catering_orders_goods_refund")
public class OrdersGoodsRefundEntity {
    @TableId(value = "id")
    private Long id;
    /** 退款表Id */
    @TableField(value = "refund_id")
    private Long refundId;
    /** 退款编号 */
    @TableField(value = "refund_number")
    private String refundNumber;
    /** 订单商品表ID */
    @TableField(value = "order_goods_id")
    private Long orderGoodsId;
    /** 退款商品数量 */
    @TableField(value = "number")
    private Integer number;
    /** 退款商品的售价 */
    @TableField(value = "price")
    private BigDecimal price;
}
