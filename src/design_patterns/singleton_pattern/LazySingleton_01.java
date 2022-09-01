package design_patterns.singleton_pattern;

import java.util.concurrent.*;

/**
 * ClassName: LazySingleton_01
 * Description: 懒汉式线程不安全创建单例
 *  懒汉式线程安全创建单例 方法上加一个synchronized关键字
 *  （实现了懒加载，线程安全方式加锁了，比较重，影响效率）
 * date: 2021/1/6 16:38
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class LazySingleton_01 {
    private static LazySingleton_01 INSTANCE;

    private LazySingleton_01() {}

    /**
     * 将实例的初始化剥离出来，在使用时在创建，但是判断实例是否为空的过程会造成线程不安全
     * @return
     */
    synchronized public static LazySingleton_01 getInstance() throws InterruptedException {
        if(INSTANCE == null) {
            Thread.sleep(500);
            INSTANCE = new LazySingleton_01();
        }
        return INSTANCE;
    }

    // 线程不安全测试
    public static void main(String[] args) {
        // 创建有返回值的多线程
        Callable<LazySingleton_01> c1 = new Callable<LazySingleton_01> () {
            @Override
            public LazySingleton_01 call() throws Exception {
                return LazySingleton_01.getInstance();
            }
        };

        // 创建两个线程的线程池
        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<LazySingleton_01> f1 = es.submit(c1);
        Future<LazySingleton_01> f2 = es.submit(c1);
        try {
            // 通过get方法获取返回的实例对象
            LazySingleton_01 s1 = f1.get();
            LazySingleton_01 s2 = f2.get();
            System.out.println(s1 == s2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            es.shutdown();
        }
    }
}
