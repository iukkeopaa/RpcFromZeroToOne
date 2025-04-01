package org.wqz.convergencerpc.Version5.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: 订单类
 * @Author: wjh
 * @Date: 2025/4/1 上午8:24
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    private Integer orderId;

    private Integer userId;

    private String content;
}
