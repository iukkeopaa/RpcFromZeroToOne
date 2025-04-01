package org.wqz.convergencerpc.Version4.client;

import lombok.AllArgsConstructor;
import org.wqz.convergencerpc.Version2.protocol.RpcRequest;
import org.wqz.convergencerpc.Version2.protocol.RpcResponse;
import org.wqz.convergencerpc.Version3.client.BaseClient;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description: 代理客户端
 * @Author: wjh
 * @Date: 2025/3/31 下午10:17
 */

@AllArgsConstructor
public class ClientProxy implements InvocationHandler {

 private RpcClient rpcClient;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        RpcRequest request = RpcRequest.builder().interfaceName(method.getDeclaringClass().getName())
                .methodName(method.getName())
                .params(args).paramsTypes(method.getParameterTypes()).build();

        RpcResponse response = rpcClient.sendRequestAndReciveRespnso(request);
        return response.getData();
    }

    <T>T getProxy(Class<T> clazz){
        Object o = Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz}, this);
        return (T)o;
    }

}
