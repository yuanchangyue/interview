package com.changyue.interview.desgin;

/**
 * @program: interview
 * @description: 单例--懒汉式 延迟创建一个实例对象 线程安全
 * 1. 构造器私有化
 * 2. 用静态变量保存
 * 3. 提供一个静态方法 获取这个实例对象
 * @author: YuanChangYue
 * @create: 2019-10-08 14:41
 */
public class Singleton5 {
    private static Singleton5 instance;

    private Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (instance == null) {
            synchronized (Singleton5.class) {
                if (instance == null) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
