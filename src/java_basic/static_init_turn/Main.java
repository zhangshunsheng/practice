package java_basic.static_init_turn;
import static java.lang.System.out;
import static java.lang.Integer.*;
/**
 * ClassName: Main
 * Description:
 * date: 2021/1/6 15:16
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class Main {
    public static void main(String[] args) {
        new Son();
        // static的作用还可以是导包，将Integer的所有静态变量或者方法直接引入便可以直接使用，不需要调用类名，
        // 其他的类也是如此
        out.println("int类型最大值" + MAX_VALUE);
    }
}
