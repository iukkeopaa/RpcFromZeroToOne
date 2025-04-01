package org.wqz.convergencerpc.Version4.service.impl;

import org.wqz.convergencerpc.Version3.pojo.Order;
import org.wqz.convergencerpc.Version4.service.OrderService;

/**
 * @Description: 订单的实现类
 * @Author: wjh
 * @Date: 2025/4/1 上午8:27
 */
public class OrderServiceimpl implements OrderService {
    @Override
    public Order getOrderById(Integer id) {
        Order order = Order.builder().userId(12).orderId(id).content("我的订单").build();

        System.out.println("客户端查询了" + id + "的订单");
        return order;
    }
}
