package java_basic;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: GenericLearn
 * Description: 泛型学习类
 * date: 2020/12/12 14:04
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class GenericLearn {
    /**
     * 当java文件转换成字节码文件的时候是没有泛型这个类型的，所有的泛型会被清除转换成指定的父类或者
     * object类对象，这个过程叫做泛型擦除
     */
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("adf");
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(123);
        System.out.println(list1.getClass() == list2.getClass());
        try{
            list2.getClass().getMethod("add", Object.class).invoke(list2, "rerer");
        }catch (Exception e) {
            throw new RuntimeException("发生错误！");
        }
        System.out.println(list2.toString());
    }
}
