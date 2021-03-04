package com.blb.Seriver;

import com.blb.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("userSeriver")
public class UserSeriver {
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;

//    public UserSeriver(UserDao userDao) {
//        this.userDao = userDao;
//    }



    public void say()
    {
        userDao.say();
    }
}
