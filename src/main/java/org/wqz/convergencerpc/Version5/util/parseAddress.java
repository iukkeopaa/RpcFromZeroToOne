package org.wqz.convergencerpc.Version5.util;

import java.net.InetSocketAddress;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/4/1 上午9:15
 */
public class parseAddress {

    private InetSocketAddress parseAddress(String address) {
        String[] result = address.split(":");
        return new InetSocketAddress(result[0], Integer.parseInt(result[1]));
    }
}
