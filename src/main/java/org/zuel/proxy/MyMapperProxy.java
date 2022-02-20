package org.zuel.proxy;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现InvocationHandler,作为Proxy.newProxyInstance的参数
 */
public class MyMapperProxy implements InvocationHandler {

    private SqlSession sqlSession;
    private Class daoClass;

    public MyMapperProxy(SqlSession sqlSession, Class daoClass) {
        this.sqlSession = sqlSession;
        this.daoClass = daoClass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 要想实现功能，即调用SqlSession的相应方法，
        // 缺SqlSession和namespace.id，前者通过构造方法，后者namespace可以通过DAO拿
        return sqlSession.selectList(daoClass.getName() + "." + method.getName());
        // 传统代理，例如打印日志
//        System.out.println("------");
//        method.invoke();
//        System.out.println("------");
    }
}
