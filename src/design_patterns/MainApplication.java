package design_patterns;

import design_patterns.classFactoaries.enums.DuckEnumFactory;
import design_patterns.classFactoaries.factoaries.StaticReflectFactoary;
import design_patterns.strategyPattern.RiverDuck;

/**
 * ClassName: MainApplication
 * Description:
 * date: 2020/11/22 9:18
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class MainApplication {
    public static void main(String[] args) {
//        RiverDuck k = new RiverDuck();
//        k.setFly(new Walk());

        RiverDuck r = StaticReflectFactoary.getClassByName(DuckEnumFactory.RIVERDUCK.getClassName());
        r.toString();
    }
}
