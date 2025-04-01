package org.wqz.convergencerpc.Version2.client;

import org.wqz.convergencerpc.Version1.pojo.User;
import org.wqz.convergencerpc.Version2.service.UserService;

/**
 * @Description: 客户端
 * @Author: wjh
 * @Date: 2025/4/1 上午8:10
 */
public class RpcClient {

    public static void main(String[] args) {



        ClientProxy clientProxy = new ClientProxy("127.0.0.1", 8888);

        UserService proxy = clientProxy.getProxy(UserService.class);

        User userByUserId = proxy.getUserByUserId(10);

        System.out.println("从服务器端得到的user为"+userByUserId);

    }
}
