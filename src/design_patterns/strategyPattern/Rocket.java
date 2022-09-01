package design_patterns.strategyPattern;

/**
 * ClassName: Rocket
 * Description:
 * date: 2020/11/22 10:15
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class Rocket implements FlyBehavior {
    @Override
    public String fly() {
        return "I got a rocket mechine, now i'm a rocket duck, i can fly!";
    }
}
