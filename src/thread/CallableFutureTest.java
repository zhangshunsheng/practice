package thread;

import java.util.concurrent.Callable;

/**
 * ClassName: CallableFutureTest
 * Description:
 * date: 2022/4/30 16:23
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class CallableFutureTest implements Callable<Integer> {

    @Override
    public Integer call() {
        return 0;
    }
}
