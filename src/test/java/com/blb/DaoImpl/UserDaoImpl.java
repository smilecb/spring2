package com.blb.DaoImpl;

import com.blb.Dao.UserDao;
import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao {
    public void say() {
        System.out.println("我是Dao");
    }
}
