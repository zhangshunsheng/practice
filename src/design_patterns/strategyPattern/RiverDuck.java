package design_patterns.strategyPattern;

/**
 * ClassName: RiverDuck
 * Description:
 * date: 2020/11/22 10:03
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class RiverDuck extends Duck {
    /**
     * 子类继承父类，将行为放入，运行时可以动态改变行为
     */
    public RiverDuck() {
        flyBehavior = new Walk();
        voiceBehavior = new Shout();
    }

}
