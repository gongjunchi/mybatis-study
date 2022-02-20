package org.zuel.dao;

import org.apache.ibatis.annotations.Param;
import org.zuel.entity.User;

import java.util.List;

public interface UserDAO {

    // 在实现动态代理时暂时注释掉此方法，否则要在调用SqlSession的insert/update时需要做方法的区分
    // public void save(User user);

    public List<User> queryAllUsers();

}
