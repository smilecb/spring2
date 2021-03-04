package com.blb.text;

import com.blb.Seriver.UserSeriver;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class demo1 {
      @Test
    public void text1()
    {
        ApplicationContext app=new ClassPathXmlApplicationContext("application.xml");
       UserSeriver userSeriver = (UserSeriver) app.getBean("userSeriver");
        userSeriver.say();
    }
}
