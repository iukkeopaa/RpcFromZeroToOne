package org.wqz.convergencerpc.Version5.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description: 用户类
 * @Author: wjh
 * @Date: 2025/3/31 下午10:00
 */

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Integer userId;

    private String userName;

    private String passWord;

    private Integer age;

    private String email;
}

