/**
 * 最经典的单例模式
 */
public class Singleton {

    /**
     * 懒汉模式
     */
    private static Singleton uniqueInstance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}


/**
 * 可以处理多线程的单例模式
 */
class Singleton2 {

    /**
     * 饿汉模式：应用程序总是创建并使用单件实例，或者在创建和运行时方面的负担不繁重。
     * 在静态初始化器（static initializer）中创建单件，保证了线程安全（thread safe）
     *
     * JVM在加载这个类时马上创建此唯一的单件实例。JVM保证任何线程在访问uniqueInstance静态变量之前，一定先创建此实例。
     */
    private static Singleton2 uniqueInstance = new Singleton2();

    private Singleton2() {}

    public static Singleton2 getInstance() {
        /**
         * 已经有实例了，直接使用
         */
        return uniqueInstance;
    }
}



/**
 * 双重校验锁模式，线程安全
 */
class Singleton3 {

    /**
     * 懒汉模式
     */
    private volatile static Singleton3 uniqueInstance;

    private Singleton3() {}

    public static Singleton3 getInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton3.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton3();
                }
            }
        }
        return uniqueInstance;
    }
}
