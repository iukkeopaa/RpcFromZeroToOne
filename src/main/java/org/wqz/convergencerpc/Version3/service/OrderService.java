package org.wqz.convergencerpc.Version3.service;

import ch.qos.logback.classic.spi.EventArgUtil;
import org.wqz.convergencerpc.Version3.pojo.Order;

public interface OrderService {

    Order getOrderById(Integer id);
}
