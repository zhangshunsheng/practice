package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ClassName: MainClass
 * Description:
 * date: 2020/12/8 22:40
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class MainClass {
    public static int count = 100;

    public static void main(String[] args) {
//        Thread threadE1 = new threadByExtend();
//        Thread threadE2 = new threadByExtend();
//        Thread threadE3 = new threadByExtend();
//        Runnable threadR1 = new threadByImplements();
//        Runnable threadR2 = new threadByImplements();
//        Runnable threadR3 = new threadByImplements();
//        threadE1.start();
//        threadE2.start();
//        threadE3.start();
//        new Thread(threadR1).start();
//        new Thread(threadR2).start();
//        new Thread(threadR3).start();

//        // 测试子类调用继承而来的父类的同步方法是否会获得锁(事实证明会)
//        SonClassTestSynExtend sonClassTestSynExtend = new SonClassTestSynExtend();
//        ThreadClassTestSynExtend t1 = new ThreadClassTestSynExtend(sonClassTestSynExtend);
//        ThreadClassTestSynExtend t2 = new ThreadClassTestSynExtend(sonClassTestSynExtend);
//        t1.start();
//        t2.start();

//          // 测试中断操作抛出InterruptedException异常终止线程
//          InterruptedExceptionTestClass ine = new InterruptedExceptionTestClass();
//          ine.start();
//          try {
//              Thread.sleep(1000);
//          } catch (InterruptedException e) {
//              e.printStackTrace();
//          }
//          ine.interrupt();

          // 测试代码块异步
//          CodeBlockSynTest codeBlockSynTest = new CodeBlockSynTest();
////          CodeBlockSynThread cbst1 = new CodeBlockSynThread(codeBlockSynTest);
////          CodeBlockSynThread cbst2 = new CodeBlockSynThread(codeBlockSynTest);
////          cbst1.start();
////          cbst2.start();

        NormalClass same = new NormalClass();
        NormalThreadThread s1 = new NormalThreadThread(same);
        NormalThreadThread s2 = new NormalThreadThread(same, "s2");
        s1.setName("s1");
        s1.start();
        s2.start();

        ExecutorService pool = Executors.newFixedThreadPool(5);
        CallableFutureTest c1 = new CallableFutureTest();
        Future aa = pool.submit(c1);
        try {
            int aaa = (Integer) aa.get();
            System.out.println(aaa);
        } catch (Exception E) {
            E.printStackTrace();
        }
    }
}
