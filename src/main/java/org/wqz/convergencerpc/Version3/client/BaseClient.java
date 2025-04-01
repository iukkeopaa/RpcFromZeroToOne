package org.wqz.convergencerpc.Version3.client;

import org.wqz.convergencerpc.Version2.protocol.RpcRequest;
import org.wqz.convergencerpc.Version2.protocol.RpcResponse;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Random;

/**
 * @Description: 基本的客户端类
 * @Author: wjh
 * @Date: 2025/3/31 下午10:12
 */
public class BaseClient {

    public static RpcResponse sendRequestAndReciveResponse(String host, int port, RpcRequest request) {


        try (Socket socket = new Socket(host, port);

             ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

             ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {


            System.out.println(request);
            objectOutputStream.writeInt(new Random().nextInt());

            objectOutputStream.flush();


            RpcResponse response = (RpcResponse) objectInputStream.readObject();

            return response;


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

            System.out.println("客户端启动失败");

            return null;


        }
    }
}

