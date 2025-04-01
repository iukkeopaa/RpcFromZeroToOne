package org.wqz.convergencerpc.Version4.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.wqz.convergencerpc.Version1.pojo.User;
import org.wqz.convergencerpc.Version4.service.UserService;

import java.util.Random;

/**
 * @Description: 用户服务的实现类
 * @Author: wjh
 * @Date: 2025/3/31 下午9:11
 */

public class UserServiceimpl implements UserService {

    public static final Logger LOG = LoggerFactory.getLogger(UserServiceimpl.class);


    @Override
    public User getUserByUserId(Integer userId) {

        LOG.info("客户端发起了查询用户id为" + userId + "的用户");

        Random random = new Random();




        //        User user1 = new User();
        //
        //        user1.setUserId(userId);
        //        user1.setUserName("james");
        //        user1.setEmail("woshidashuaige@qq.com");
        //        user1.setPassWord("123456abc");
        //        user1.setAge(random.nextInt());


        User user = User.builder().userName("james")
                .userId(userId)
                .email("woshidashuaige@qq.com")
                .age(random.nextInt())
                .passWord("123456abc")
                .build();

        return user;

    }

    @Override
    public Integer insertUser(User user) {

        System.out.println("插入一个用户成功" + user);
        return 0;
    }
}
