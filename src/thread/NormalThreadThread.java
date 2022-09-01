package thread;

/**
 * ClassName: NormalThreadThread
 * Description:
 * date: 2022/4/30 16:05
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class NormalThreadThread extends Thread {
    private NormalClass a;

    public NormalThreadThread(NormalClass a) {
        this.a = a;
    }

    public NormalThreadThread(NormalClass a, String name) {
        this.a = a;
        this.setName(name);
    }
    @Override
    public void run() {
        a.getOutNumAndprint();
        a.getInnerNumAndprint();
    }
}
