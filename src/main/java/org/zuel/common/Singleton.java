package org.zuel.common;

public class Singleton {

    private static volatile Singleton instance;

    // 构造函数设置为private，确保其它类中不能new一个本类的实例
    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
