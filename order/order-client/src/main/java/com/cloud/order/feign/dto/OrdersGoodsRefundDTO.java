package com.cloud.order.feign.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author wxf
 * @date 2020/6/11 17:51
 * @description 简单描述
 **/
@Data
@Accessors(chain = true)
public class OrdersGoodsRefundDTO {
    private Long id;
    /** 退款表Id */
    private Long refundId;
    /** 退款编号 */
    private String refundNumber;
    /** 订单商品表ID */
    private Long orderGoodsId;
    /** 退款商品数量 */
    private Integer number;
    /** 退款商品的售价 */
    private BigDecimal price;
}
