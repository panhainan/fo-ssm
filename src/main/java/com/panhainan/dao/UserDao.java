package com.panhainan.dao;

import com.panhainan.entity.User;

/**
 * 测试案例：User的数据访问接口
 * @author panhainan
 * @email panhainan@yeah.net
 * @version 1.0
 */
public interface UserDao {

    int insert(User user);

    int updateBaseInfoById(User user);

    User selectById(int userId);

    User selectByUserName(String userName);

    User selectByUserEmail(String userEmail);
}
