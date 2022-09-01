package algorithm;

/**
 * ClassName: BubbleSort
 * Description: 冒泡排序
 * date: 2020/11/10 0:25
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public final class BubbleSort {
    /**
     * 冒泡排序算法
     * @param data 待排序数据
     */
    public static final int[] bubbleSortAlgorithms(final int[] data) {
        if (data.length < 2) {
            return data;
        }
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] < data[j]) {
                    PublicCommonUtils.swap(data, i, j);
                }
            }
        }
        return data;
    }
}
