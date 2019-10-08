package com.changyue.interview.desgin;

/**
 * @program: interview
 * @description: 单例---饿汉式  类初始化直接创建对象 不管是否需要这个对象 线程安全
 * <p>
 * 1. 构造器私有化
 * 2. 私有变量保存
 * <p>
 * @author: YuanChangYue
 * @create: 2019-10-08 14:05
 */
public class Singleton1 {

    public static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }

}
