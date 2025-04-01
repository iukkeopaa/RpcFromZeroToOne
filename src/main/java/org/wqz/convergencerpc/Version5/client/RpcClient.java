package org.wqz.convergencerpc.Version5.client;

import org.wqz.convergencerpc.Version5.protocol.RpcRequest;
import org.wqz.convergencerpc.Version5.protocol.RpcResponse;

public interface RpcClient {



    RpcResponse sendRequestAndReciveRespnso(RpcRequest request);


}
