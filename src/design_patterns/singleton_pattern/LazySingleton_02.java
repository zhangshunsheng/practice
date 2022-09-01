package design_patterns.singleton_pattern;

/**
 * ClassName: LazySingleton_02
 * Description: 懒汉式 -- 静态内部类创建
 *  线程安全，懒汉式
 * date: 2021/1/6 17:06
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class LazySingleton_02 {

    /**
     *  使用静态内部类的方法初始化对象，因为静态内部类不会随着外部类的加载而加载，所以能够实现懒加载的效果
     *  又由于静态内部类内部实现的是直接赋值的方式进行实例化，所以不存在线程安全问题。
     */

    private static class inner {
        private static LazySingleton_02 Instance = new LazySingleton_02();
    }

    private LazySingleton_02() {}

    public LazySingleton_02 getInstance() {
        return inner.Instance;
    }
}
