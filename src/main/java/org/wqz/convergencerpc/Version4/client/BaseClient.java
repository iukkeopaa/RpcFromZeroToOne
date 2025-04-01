package org.wqz.convergencerpc.Version4.client;

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
public class BaseClient implements RpcClient {

    private String host;

    private int port;


    @Override
    public RpcResponse sendRequestAndReciveRespnso(RpcRequest request) {
        try {
            Socket socket = new Socket(host, port);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            System.out.println(request);
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

            RpcResponse response = (RpcResponse) objectInputStream.readObject();

            //System.out.println(response.getData());
            return response;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println();
            return null;
        }
    }
    }
}

