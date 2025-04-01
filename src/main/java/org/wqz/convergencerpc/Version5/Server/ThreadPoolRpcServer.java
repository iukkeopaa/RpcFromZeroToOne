package org.wqz.convergencerpc.Version5.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 线程池版服务器端
 * @Author: wjh
 * @Date: 2025/4/1 上午8:43
 */
public class ThreadPoolRpcServer implements RpcServerLifeCircle {


    private final ThreadPoolExecutor threadPool;

    private ServiceProvider serviceProvider;

    public ThreadPoolRpcServer(ServiceProvider serviceProvider){

        threadPool = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),200,60, TimeUnit.SECONDS,new ArrayBlockingQueue<>(50));

        this.serviceProvider=serviceProvider;

    }

    public ThreadPoolRpcServer(ServiceProvider serviceProvider, int corePoolSize,
                               int maximumPoolSize,
                               long keepAliveTime,
                               TimeUnit unit,
                               BlockingQueue<Runnable> workQueue){

        threadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.serviceProvider = serviceProvider;
    }
    @Override
    public void start(int port) {
        System.out.println("线程池版服务端启动了");
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while(true){
                Socket socket = serverSocket.accept();
                threadPool.execute(new WorkThread(socket,serviceProvider));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void stop() {

    }
}
