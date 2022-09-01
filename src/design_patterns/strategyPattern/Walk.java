package design_patterns.strategyPattern;

/**
 * ClassName: Walk
 * Description:
 * date: 2020/11/22 10:00
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class Walk implements FlyBehavior {
    @Override
    public String fly() {
        return "i can't fly";
    }
}
