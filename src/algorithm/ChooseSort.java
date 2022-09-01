package algorithm;

/**
 * ClassName: ChooseSort
 * Description: 选择排序
 * date: 2020/11/11 12:33
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public final class ChooseSort {

    /*
        选择排序：
            核心思想 -- 每次选择一个最小的数放到数组开头，再次扫描剩下的数找到第二小的数放到数组第二位，依次进行直至完成。
            时间复杂度 f(N) = O(N*N)
            空间复杂度 O(1) （因为只需要一个过渡变量）
     */

    public static final void chooseSort(final int[] arrays, final int sIndex, final int eIndex) {
        if (arrays.length < 2 || eIndex - sIndex < 2) {
            return;
        }
        for (int i = sIndex; i < eIndex - 1; i++) {
            int minIndex = i;
            for(int j = i + 1; j < eIndex; j++) {
                if(arrays[j] < arrays[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                PublicCommonUtils.swap(arrays, i, minIndex);
            }
        }
    }

}
