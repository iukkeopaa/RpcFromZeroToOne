package org.wqz.convergencerpc.Version3.service;

import org.wqz.convergencerpc.Version1.pojo.User;

public interface UserService {

    User getUserByUserId(Integer userId);

    Integer insertUser(User user);

}
