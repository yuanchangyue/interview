package com.changyue.interview.test;

import com.changyue.interview.desgin.*;

import java.util.concurrent.*;

/**
 * @program: interview
 * @description: 单例测试
 * @author: YuanChangYue
 * @create: 2019-10-08 14:26
 */
public class SingletonTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //构造器
        Singleton1 singleton1 = Singleton1.INSTANCE;
        //枚举
        Singleton2 singleton2 = Singleton2.INSTANCE;
        //static
        Singleton3 singleton3 = Singleton3.INSTANCE;

        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton3);

       /*
         //可能存在线程安全问题
        Singleton4 singleton41 = Singleton4.getInstance();
        Singleton4 singleton42 = Singleton4.getInstance();

        System.out.println(singleton41);
        System.out.println(singleton42);
        System.out.println(singleton41 == singleton42);
        */

        Callable<Singleton5> callable = Singleton5::getInstance;
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Singleton5> f1 = service.submit(callable);
        Future<Singleton5> f2 = service.submit(callable);

        Singleton5 singleton41 = f1.get();
        Singleton5 singleton42 = f2.get();

        System.out.println(singleton41);
        System.out.println(singleton42);
        System.out.println(singleton41 == singleton42);

        service.shutdown();

        Singleton6 singleton6 = Singleton6.getInstance();
        System.out.println(singleton6);
    }
}
