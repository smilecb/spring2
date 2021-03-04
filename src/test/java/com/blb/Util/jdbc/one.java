package com.blb.Util.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class one {
    @Test
    /**
     * jdbc连接
     */
    public void text1() throws SQLException, PropertyVetoException {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        //设置基本连接信息
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/one?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUser("root");
        dataSource.setPassword("199866");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //释放资源
        connection.close();
    }
    @Test
    /**
     * jdbc连接厂库的配置
     */
    public void text2() throws SQLException, PropertyVetoException {
        ResourceBundle re=ResourceBundle.getBundle("jdbc");
        String driver = re.getString("driver");
        String url = re.getString("url");
        String username = re.getString("username");
        String psaaword = re.getString("psaaword");
        System.out.println(driver);
        System.out.println(url);
        System.out.println(username);
        System.out.println(psaaword);
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(psaaword);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }

    @Test
    /**
     * jdbc解耦（连接xml配置文件）
     */
    public void text3() throws SQLException {
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("application.xml");
        DataSource dataSource=(DataSource) applicationContext.getBean("jdbcDataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
    @Test
    public  void text4() throws SQLException {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
        DataSource jdbcData =(DataSource) applicationContext.getBean("jdbcData");
        Connection connection = jdbcData.getConnection();
        System.out.println(connection);
        connection.close();
    }
    @Test
    public void text5(){
    }
}
