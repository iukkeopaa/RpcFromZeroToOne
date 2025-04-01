package org.wqz.convergencerpc.Version5.util;

import java.net.InetSocketAddress;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/4/1 上午9:15
 */
public class ServiceAddress {
    private String getServiceAddress(InetSocketAddress serverAddress) {
        return serverAddress.getHostName() +
                ":" +
                serverAddress.getPort();
    }
}
