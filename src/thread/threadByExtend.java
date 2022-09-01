package thread;

/**
 * ClassName: threadByExtend
 * Description:
 * date: 2020/12/8 22:40
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class threadByExtend extends Thread {
    @Override
    public void run() {
        super.run();
        MainClass.count--;
        System.out.println("现在运行的线程是：" + this.getName() + "，票数剩余：" + MainClass.count);
    }
}
