package algorithm;

/**
 * ClassName: InsertSort
 * Description: 插入排序
 * date: 2020/11/11 12:45
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public final class InsertSort {

    /*
        插入排序：
            核心思想 -- 基本思想是将一个记录插入到已经排好序的有序表中，从而一个新的、记录数增1的有序表。
                        每次扫描相邻的两个数，把小的放前面，依次进行直至完成。
            时间复杂度 f(N) = O(N*N)
            空间复杂度 O(1) （因为只需要一个过渡变量）
     */

    public static final void insertSort(final int[] arrays, final int sIndex, final int eIndex) {
        if (arrays.length < 2 || eIndex - sIndex < 2) {
            return;
        }
        // i 是记录已经排序完成的子序列下标
        for (int i = sIndex; i < eIndex - 1; i++) {
            for(int j = i + 1; j > sIndex; j--) {
                if(arrays[j] < arrays[j - 1]) {
                    PublicCommonUtils.swap(arrays, j, j - 1);
                } else {
                    // 在待比较的数前面的所有数均已排序完成
                    break;
                }
            }
        }
    }
}
