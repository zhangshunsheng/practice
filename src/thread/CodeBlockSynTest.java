package thread;

/**
 * ClassName: CodeBlockSynTest
 * Description:
 * date: 2020/12/9 23:48
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class CodeBlockSynTest {
    public void sout () {
        for(int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ",part a :" + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized (this) {
            for(int i = 0; i < 30; i++) {
                System.out.println(Thread.currentThread().getName() + ",part syn :" + i);
            }
        }

        for(int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ",part b :" + i);
        }
    }
}
