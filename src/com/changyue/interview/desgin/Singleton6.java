package com.changyue.interview.desgin;


/**
 * @program: interview
 * @description: 单例--懒汉式 延迟创建一个实例对象 线程安全
 * 1. 构造器私有化
 * 2. 用内部类初始时才创建
 * 3. 提供一个静态方法 获取这个实例对象
 * @author: YuanChangYue
 * @create: 2019-10-08 14:41
 */
public class Singleton6 {

    private Singleton6() {
    }

    private static class Inner {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return Inner.INSTANCE;
    }

}
