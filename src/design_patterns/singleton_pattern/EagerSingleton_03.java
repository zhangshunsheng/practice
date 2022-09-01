package design_patterns.singleton_pattern;

import java.util.Properties;

/**
 * ClassName: EagerSingleton_03
 * Description: 静态代码块创建
 * date: 2021/1/6 16:09
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class EagerSingleton_03 {
    private static EagerSingleton_03 INSTANCE;

    static {
        // 将单例对象的初始化过程剥离出来用静态代码块的方法实现可以增加一些操作，比如对配置文件的读取
        // 此代码块只会执行一次，在程序启动时类加载的时候，注意，类加载而不是类调用，调用不会执行，因为是静态代码块
        INSTANCE = new EagerSingleton_03();
        Properties properties = new Properties();
        try {
            properties.load(EagerSingleton_03.class.getClassLoader().getResourceAsStream("application.properties"));
            System.out.println(properties.getProperty("test"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private EagerSingleton_03() {}
    public static EagerSingleton_03 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        EagerSingleton_03 s1 = EagerSingleton_03.getInstance();
        EagerSingleton_03 s2 = EagerSingleton_03.getInstance();
        System.out.println(s1 == s2);
    }
}
