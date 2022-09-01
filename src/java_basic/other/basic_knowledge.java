package java_basic.other;

/**
 * ClassName: basic_knowledge
 * Description:
 * date: 2022/4/12 20:00
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class basic_knowledge {

    // == 跟 equals 的比较
    public void valCompare() {
        int a = 128;
        int a2 = 128;
        System.out.println(a == a2);
        Integer aa1 = 128;
        Integer aa2 = 128;
        System.out.println(a == aa2);
        System.out.println(aa1 == aa2);
        int aaa3 = 127;
        Integer aaa1 = 127;
        Integer aaa2 = 127;
        System.out.println(aaa3 == aaa2);
        System.out.println(aaa1 == aaa2);
        double b = 128.1;
        double b2 = 128.1;
        System.out.println(b == b2);
        Double bb1 = 128.1;
        Double bb2 = 128.1;
        System.out.println(bb1 == bb2);
        String ss1, ss2 = "hello";
        String ss3 = new String("hello");
    }
    public static void main(String[] args) {
        new basic_knowledge().valCompare();
    }
}
