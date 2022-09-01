package thread;

/**
 * ClassName: InterruptedExceptionTestClass
 * Description:
 * date: 2020/12/9 23:34
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class InterruptedExceptionTestClass extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("我沉睡10秒钟");
        try {
            Thread.sleep(10000);
            System.out.println("沉睡结束");
        } catch (InterruptedException e) {
            System.out.println("中断了，进入catch");
        }
    }
}
