package org.wqz.convergencerpc.Version4.client;

import org.wqz.convergencerpc.Version4.protocol.RpcRequest;
import org.wqz.convergencerpc.Version4.protocol.RpcResponse;

public interface RpcClient {



    RpcResponse sendRequestAndReciveRespnso(RpcRequest request);


}
