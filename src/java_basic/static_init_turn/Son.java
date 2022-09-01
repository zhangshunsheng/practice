package java_basic.static_init_turn;

/**
 * ClassName: Son
 * Description:
 * date: 2021/1/6 15:15
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class Son extends Parent{

    private static String val = sonStaticMethod();
    private String val2 = sonStaticMethod2();
    private String val4 = sonStaticMethod4();

    public Son() {
        System.out.println("子类构造方法");
    }

    static {
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类非静态代码块");
    }

    private static String sonStaticMethod() {
        System.out.println("子类赋予静态属性的静态方法");
        return null;
    }

    private static String sonStaticMethod2() {
        System.out.println("子类赋予非静态属性的静态方法");
        return null;
    }

    private static String sonStaticMethod3() {
        System.out.println("子类没有赋予属性的静态方法");
        return null;
    }

    private String sonStaticMethod4() {
        System.out.println("子类赋予非静态属性的普通方法");
        return null;
    }

}
