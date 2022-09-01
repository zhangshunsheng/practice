package design_patterns.singleton_pattern;

/**
 * ClassName: EagerSingleton_01
 * Description: 单例模式--饿汉式--直接创建
 * date: 2021/1/6 15:09
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class EagerSingleton_01 {
    /**
     * 饿汉式单例模式三要素：
     *      1、只有一个实例
     *      2、对实例进行保存
     *      3、对外暴露
     */

    // 2
    private static EagerSingleton_01 INSTANCE = new EagerSingleton_01();

    // 1
    private EagerSingleton_01() {}

    // 3
    public EagerSingleton_01 getInstance() {
        return INSTANCE;
    }

}
