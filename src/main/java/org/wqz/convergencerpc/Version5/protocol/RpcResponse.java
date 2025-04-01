package org.wqz.convergencerpc.Version5.protocol;

import lombok.Builder;
import lombok.Data;
import org.wqz.convergencerpc.Version2.protocol.ResponseStatus;

/**
 * @Description: 响应类
 * @Author: wjh
 * @Date: 2025/3/31 下午10:01
 */

@Data
@Builder
public class RpcResponse {

    // 状态信息
    private int code;
    private String message;
    // 具体数据
    private Object data;

    private Class<?> dataType;

    public static RpcResponse success(Object data) {
        return RpcResponse.builder()
                .code(ResponseStatus.SUCCESS.getCode())
                .message(ResponseStatus.SUCCESS.getMessage())
                .data(data)
                .build();
    }

    /**
     * 创建失败响应
     * @param status 响应状态枚举
     * @return 失败的 Rpcresponse 实例
     */
    public static RpcResponse fail(ResponseStatus status) {
        return RpcResponse.builder()
                .code(status.getCode())
                .message(status.getMessage())
                .data(null)
                .build();
    }

    /**
     * 创建自定义失败响应
     * @param code 自定义错误状态码
     * @param message 自定义错误消息
     * @return 失败的 Rpcresponse 实例
     */
    public static RpcResponse fail(int code, String message) {
        return RpcResponse.builder()
                .code(code)
                .message(message)
                .data(null)
                .build();
    }


    /**
     * 创建基本的成功响应
     * @param data 返回的数据
     * @return 成功的响应实例
     */
    public static RpcResponse basicSuccess(Object data){

        return RpcResponse.builder()
                .code(200)
                .message("成功")
                .data(data)
                .build();
    }

    public static RpcResponse basicFail(){

        return RpcResponse.builder()
                .code(500)
                .message("服务器发生错误")
                .build();
    }

}
