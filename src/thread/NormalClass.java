package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: NormalClass
 * Description:
 * date: 2022/4/30 15:59
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class NormalClass {

    private int count = 30;

    public void getOutNumAndprint() {
        List a = new ArrayList<Integer>();
        while(count > 0) {
            a.add(count);
            count--;
            if (count == 15) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("当前进入线程out：" + Thread.currentThread().getName() + a.toString());
    }

    public void getInnerNumAndprint() {
        int num = 30;
        List a = new ArrayList<Integer>();
        while(num > 0) {
            a.add(num);
            num--;
            if (num == 15) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("当前进入线程inner：" + Thread.currentThread().getName() + a.toString());
    }
}
