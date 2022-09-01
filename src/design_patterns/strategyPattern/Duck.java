package design_patterns.strategyPattern;

/**
 * ClassName: Duck
 * Description:
 * date: 2020/11/22 9:24
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    VoiceBehavior voiceBehavior;
    public void setFly(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
    // all the son class the same, so it can't be override;
    public final void swim() {
        System.out.println("i'm a swimming duck");
    };
    public void setVoice(VoiceBehavior voiceBehavior) {
        this.voiceBehavior = voiceBehavior;
    }

    @Override
    public String toString() {
        return "Duck{" +
                "flyBehavior=" + flyBehavior.fly() +
                ", voiceBehavior=" + voiceBehavior.voice() +
                '}';
    }
}

