package org.wqz.convergencerpc.Version4.Server;

import org.wqz.convergencerpc.Version4.service.OrderService;
import org.wqz.convergencerpc.Version4.service.UserService;
import org.wqz.convergencerpc.Version4.service.impl.OrderServiceimpl;
import org.wqz.convergencerpc.Version4.service.impl.UserServiceimpl;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/4/1 上午8:38
 */
public class TestServer {
    public static void main(String[] args) {

        UserService userService = new UserServiceimpl();

        OrderService orderService = new OrderServiceimpl();

        ServiceProvider serviceProvider = new ServiceProvider();

        serviceProvider.provideServiceInterface(userService);
        serviceProvider.provideServiceInterface(orderService);

        RpcServer rpcServer = new RpcServer(serviceProvider);

        rpcServer.start(9090);



    }


}
