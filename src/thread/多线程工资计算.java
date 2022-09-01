package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: 多线程工资计算
 * Description:
 * date: 2022/5/18 15:26
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class 多线程工资计算 {
    public void count() {
        ArrayList<Integer> list = new ArrayList<>(800);
        for (int i = 0; i < 800; i++) {
            list.add(i);
        }
        final int threadNum = 8;
        int dealNum = list.size() / threadNum;
        final CountDownLatch endGate = new CountDownLatch(threadNum);
        ExecutorService pool = Executors.newFixedThreadPool(threadNum);
        for(int i = 0; i < threadNum; i++) {
            List list1 = list.subList(dealNum*i, (i+1)*dealNum);
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println(Thread.currentThread().getName() + "计算结束,总计算值：" + list1.size());
                        endGate.countDown();
                    }
                }
            };
            pool.submit(runnable);
        }
        try {
            endGate.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new 多线程工资计算().count();
        System.out.println("计算所用时间为：" + (System.currentTimeMillis() - start) + "毫秒");
    }
}
