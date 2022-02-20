package org.zuel;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.zuel.dao.UserDAO;
import org.zuel.entity.User;
import org.zuel.proxy.MyMapperProxy;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class TestMybatis {

    /**
     * 测试MyBatis的基本开发步骤
     */
    @Test
    public void test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        List<User> users = userDAO.queryAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试MyBatis sqlSession的第二种用法
     */
    @Test
    public void test2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 用namespace加id的形式确定唯一的sql
        List<User> users = sqlSession.selectList("org.zuel.dao.UserDAO.queryAllUsers");
        // 相应的还有insert/delete/update等
        /**
         * sqlSession.insert();
         */
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试JDBC
     */
    @Test
    public void testJDBC() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("");
        conn.prepareStatement("");
    }

    /**
     * 测试MyBatis的基本开发步骤
     */
    @Test
    public void test3() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        sqlSession.insert("");
    }

    /**
     * 测试Proxy
     */
    @Test
    public void testProxy() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 等价于UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
        UserDAO userDAO = (UserDAO) Proxy.newProxyInstance(TestMybatis.class.getClassLoader(),
                new Class[]{UserDAO.class}, new MyMapperProxy(sqlSession, UserDAO.class));
        List<User> users = userDAO.queryAllUsers();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
