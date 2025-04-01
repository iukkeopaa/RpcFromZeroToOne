package org.wqz.convergencerpc.Version2.protocol;

import lombok.Builder;
import lombok.Data;

/**
 * @Description: 请求类
 * @Author: wjh
 * @Date: 2025/3/31 下午10:01
 */

@Data
@Builder
public class RpcRequest {

    // 服务类名，客户端只知道接口名，在服务端中用接口名指向实现类
    private String interfaceName;
    // 方法名
    private String methodName;
    // 参数列表
    private Object[] params;
    // 参数类型
    private Class<?>[] paramsTypes;
}
