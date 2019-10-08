package com.changyue.interview.desgin;

import java.io.IOException;
import java.util.Properties;

/**
 * @program: interview
 * @description: 单例---饿汉式  类初始化直接创建对象 不管是否需要这个对象 线程安全
 * @author: YuanChangYue
 * @create: 2019-10-08 14:05
 */
public class Singleton3 {
    public static final Singleton3 INSTANCE;
    private String info;

    static {
        try {
            Properties properties = new Properties();
            properties.load(Singleton3.class.getClassLoader().getResourceAsStream("single.properties"));
            INSTANCE = new Singleton3(properties.getProperty("info"));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    private Singleton3(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Singleton3{" +
                "info='" + info + '\'' +
                '}';
    }
}
