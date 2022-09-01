package thread;

/**
 * ClassName: ThreadClassTestSynExtend
 * Description:
 * date: 2020/12/9 23:19
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class ThreadClassTestSynExtend extends Thread {
    private SonClassTestSynExtend sonClassTestSynExtend;
    public ThreadClassTestSynExtend(SonClassTestSynExtend sonClassTestSynExtend) {
        this.sonClassTestSynExtend = sonClassTestSynExtend;
    }

    @Override
    public void run() {
        super.run();
        this.sonClassTestSynExtend.sonSout();
    }
}
