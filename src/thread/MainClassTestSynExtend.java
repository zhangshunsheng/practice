package thread;

/**
 * ClassName: MainClassTestSynExtend
 * Description:
 * date: 2020/12/9 23:12
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class MainClassTestSynExtend {

    synchronized public void sout() {
        try{
            System.out.println("当前线程名称：" + Thread.currentThread().getName() + ",begin");
            Thread.sleep(3000);
            System.out.println("当前线程名称：" + Thread.currentThread().getName() + ",end");
        } catch (InterruptedException e) {
            System.out.println("线程中断了");
        }
    }
}
