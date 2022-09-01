package thread;

/**
 * ClassName: threadByImplements
 * Description:
 * date: 2020/12/8 22:41
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class threadByImplements implements Runnable {
    @Override
    public void run() {
        MainClass.count--;
        System.out.println("现在运行的线程是：" + Thread.currentThread().getName() + "，票数剩余：" + MainClass.count);
    }
}
