package org.wqz.convergencerpc.Version1.Server;

import org.wqz.convergencerpc.Version1.pojo.User;
import org.wqz.convergencerpc.Version1.service.impl.UserServiceimpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CompletableFuture;

/**
 * @Description: 异步 IO 处理的服务器端
 * @Author: wjh
 * @Date: 2025/3/31 下午9:11
 */
public class RpcServerAsync {

    public static void main(String[] args) {
        UserServiceimpl userServiceimpl = new UserServiceimpl();

        try (ServerSocket serverSocket = new ServerSocket(9999)) {
            System.out.println("服务器端启动");

            while (true) {
                Socket socket = serverSocket.accept();

                CompletableFuture.runAsync(() -> {
                    try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                         ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {

                        Integer userId = objectInputStream.readInt();
                        User userByUserId = userServiceimpl.getUserByUserId(userId);

                        objectOutputStream.writeObject(userByUserId);
                        objectOutputStream.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("出现错误");
                    } finally {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败");
        }
    }
}    