package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * ClassName: TestDataClass
 * Description: 获取测试数据类
 * date: 2020/11/9 23:21
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public final class TestDataClass {

    /**
     * 获取0-200内的随机int数组
     * @param num 数组长度
     * @return
     */
    public static final int[] getRandomIntData(final int num) {
        if (num < 1) {
            return new int[0];
        }
        final int[] dataArray = new int[num];
        for (int i = 0; i < num; i++) {
            dataArray[i] = (int)(Math.random() * 100);
        }
        return dataArray;
    }

    /**
     * 获取0-10内的随机double数组
     * @param num 数组长度
     * @return
     */
    public static final double[] getRandomDoubleData(final int num) {
        if (num < 1) {
            return new double[0];
        }
        final double[] dataArray = new double[num];
        for (int i = 0; i < num; i++) {
            dataArray[i] = Math.random() * 10;
        }
        ArrayList a = new ArrayList();
        a.add(5.22);
        HashMap as = new HashMap();
        return dataArray;
    }
}
