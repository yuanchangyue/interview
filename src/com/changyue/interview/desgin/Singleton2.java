package com.changyue.interview.desgin;

/**
 * @program: interview
 * @description: 单例---饿汉式  类初始化直接创建对象 不管是否需要这个对象 线程安全
 * <p>
 * 枚举类 该类型的对象只有几个有限的状态 通过限定一个 就是单例了
 * <p>
 * @author: YuanChangYue
 * @create: 2019-10-08 14:05
 */
public enum Singleton2 {
    //单例
    INSTANCE
}
