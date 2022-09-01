package design_patterns.classFactoaries.enums;

import design_patterns.strategyPattern.Quiet;
import design_patterns.strategyPattern.RiverDuck;
import design_patterns.strategyPattern.Walk;

/**
 * ClassName: DuckEnumFactory
 * Description:
 * date: 2020/11/22 10:43
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public enum DuckEnumFactory {
    RIVERDUCK(new RiverDuck().getClass().getName()),
    QUIET(new Quiet().getClass().getName()),
    WALK(new Walk().getClass().getName());

    private String className;
    DuckEnumFactory(String className) {
        this.className = className;
    }
    public String getClassName() {
        return className;
    }
}
