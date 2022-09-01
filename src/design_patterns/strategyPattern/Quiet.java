package design_patterns.strategyPattern;

/**
 * ClassName: Quiet
 * Description:
 * date: 2020/11/22 10:17
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class Quiet implements VoiceBehavior {
    @Override
    public String voice() {
        return "i’m a Quiet duck!";
    }
}
