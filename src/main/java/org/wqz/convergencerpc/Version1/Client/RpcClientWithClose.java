package org.wqz.convergencerpc.Version1.Client;


import org.wqz.convergencerpc.Version1.pojo.User;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;


/**
 * @Description: 客户端
 * @Author: wjh
 * @Date: 2025/3/31 下午9:10
 */
public class RpcClientWithClose {


    public static void main(String[] args) {
        Socket socket = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            socket = new Socket("127.0.0.1", 9999);
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());


            objectOutputStream.writeInt(new Random().nextInt());
            objectOutputStream.flush();


            User user = (User) objectInputStream.readObject();
            System.out.println("服务器端返回的User:" + user);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("客户端启动失败");
        } 
    }
}    
