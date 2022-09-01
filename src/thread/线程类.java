package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: 线程类
 * Description:
 * date: 2022/5/18 15:27
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class 线程类 extends Thread {
    List<Integer> list = new ArrayList<>();

    public 线程类(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for(int i = 0; i < list.size(); i++) {
            try {
                // 计算耗时100ms
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
