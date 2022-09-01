package design_patterns.strategyPattern;

import design_patterns.classFactoaries.enums.DuckEnumFactory;
import design_patterns.classFactoaries.factoaries.StaticReflectFactoary;

/**
 * ClassName: ModelDuck
 * Description:
 * date: 2020/11/22 11:17
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class ModelDuck extends Duck {
    public ModelDuck() {
        setFly(StaticReflectFactoary.getClassByName(DuckEnumFactory.WALK.getClassName()));
        setVoice(StaticReflectFactoary.getClassByName(DuckEnumFactory.QUIET.getClassName()));
    }
}
