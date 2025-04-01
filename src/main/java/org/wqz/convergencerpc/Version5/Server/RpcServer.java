package org.wqz.convergencerpc.Version5.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Description: 服务器端
 * @Author: wjh
 * @Date: 2025/4/1 上午8:34
 */
public class RpcServer implements RpcServerLifeCircle {


    private ServiceProvider serviceProvider;

    public RpcServer(ServiceProvider serviceProvider){
        this.serviceProvider=serviceProvider;


    }
    @Override
    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务端启动了");
            // BIO的方式监听Socket
            while (true){
                Socket socket = serverSocket.accept();
                // 开启一个新线程去处理
                new Thread(new WorkThread(socket,serviceProvider)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }

    }

    @Override
    public void stop() {

    }
}
