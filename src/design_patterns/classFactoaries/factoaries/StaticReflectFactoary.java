package design_patterns.classFactoaries.factoaries;

/**
 * ClassName: StaticReflectFactoary
 * Description: 通过反射建立对象工厂获取对象
 * date: 2020/11/22 10:22
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public final class StaticReflectFactoary<T> {
    public static <T> T getClassByName(final String classname) {
        try {
            return (T)Class.forName(classname).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            System.out.println("Error happened during excuting the method getClassByName");
            return null;
        }
    }
}
