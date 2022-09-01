package java_basic.static_init_turn;

/**
 * ClassName: Parent
 * Description:
 * date: 2021/1/6 15:15
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class Parent {
    private static String val = parentStaticMethod();
    private String val2 = parentStaticMethod2();
    private String val4 = parentStaticMethod4();

    public Parent() {
        System.out.println("父类构造方法");
    }

    static {
        System.out.println("父类静态代码块");
    }

    {
        System.out.println("父类非静态代码块");
    }

    private static String parentStaticMethod() {
        System.out.println("父类赋予静态属性的静态方法");
        return null;
    }

    private static String parentStaticMethod2() {
        System.out.println("父类赋予非静态属性的静态方法");
        return null;
    }

    private static String parentStaticMethod3() {
        System.out.println("父类没有赋予属性的静态方法");
        return null;
    }

    private String parentStaticMethod4() {
        System.out.println("父类赋予非静态属性的普通方法");
        return null;
    }

}
