package design_patterns.strategyPattern;

/**
 * ClassName: Shout
 * Description:
 * date: 2020/11/22 10:11
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class Shout implements VoiceBehavior {
    @Override
    public String voice() {
        return "my voice is very very big";
    }
}
