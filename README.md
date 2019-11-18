

---

## 单例模式

> 这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。保证一个类仅有一个实例，并提供一个访问它的全局访问点。

### 单例---饿汉式 

- 类初始化直接创建对象 不管是否需要这个对象 线程安全

```java
/**
 * <p>
 * 1. 构造器私有化 不能被实例化
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
```

- 枚举类 该类型的对象只有几个有限的状态 通过限定一个 就是单例了

```java
/**
 * @author: YuanChangYue
 * @create: 2019-10-08 14:05
 */
public enum Singleton2 {
    //单例
    INSTANCE
}

```

- 在静态块中初始化，从properties文件中读取带参构造器的值。

```java
/**
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
```

### 单例--懒汉式 

- 延迟创建一个实例对象 线程安全问题  出现创建不同的对象

```java
/**
 * 1. 构造器私有化
 * 2. 用静态变量保存
 * 3. 提供一个静态方法 获取这个实例对象
 * @author: YuanChangYue
 * @create: 2019-10-08 14:41
 */
public class Singleton4 {
    private static Singleton4 instance;

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton4();
        }
        return instance;
    }
}
```

- 单例--懒汉式  延迟创建一个实例对象 使用**synchronized**保证 线程安全

```java
/**
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
```

- 单例--懒汉式 延迟创建一个实例对象 **通过内部类初始化** 线程安全 

```java
/**
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
```

---







