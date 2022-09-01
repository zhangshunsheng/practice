package algorithm;

/**
 * ClassName: MergeSort
 * Description:
 * date: 2020/11/10 19:43
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public final class MergeSort {

    /*
        归并排序：
            核心思想 -- 分治、递归。将待排序数组递归分为对称的两部分，使左右两边都形成有序的数组、
                然后拿到一个等大的数组将两边的数逐一比较放入并重写回原数组，最终形成一个有序数组。
            时间复杂度 O(N) = NlogN
                计算过程：Master公式
                    T(N) = a*T(N/b) + O(N^d)
                    1) 如果log(b,a) > d –> 复杂度为O(N^log(b,a))
                    2) 如果log(b,a) = d –> 复杂度为O(N^d * logN)
                    3) 如果log(b,a) < d –> 复杂度为O(N^d)
                解析：1、我们设mergeSort的时间复杂度为T(N)
                      2、从宏观上看，他分别调用了两次自己的函数mergeSort和一次merge,那么T(N)等于两次mergeSort的时间复杂度和一次merge的时间复杂度
                      3、调用自己的函数的时候，函数个数为N/2，则T(N)=2*T(N/2)+一次merge的时间复杂度
                      4、根据上面的流程分析merge总共扫描了N个数，执行了N次，所以时间复杂度为O(N)
                      5、所以T(N)=2*(N/2)+O(N)
                      6、根据Master公式，此时a=2,b=2,d=1,满足log(b,a) = d
                      7、所以归并排序时间复杂度为：O(N^d * logN)=O(N* logN)
            空间复杂度 O(N) （因为每次是申请一个等大数组，所以需要的最大数组空间为N）
     */

    /**
     * 归并排序
     * @param src 待排序数据
     * @param low 排序下标
     * @param high 排序上标
     */
    public static final void mergeSort (int[] src, int low, int high) {
        int mid = (low + high) >>> 1;
        if (low > high) {
            int t = low;
            low = high;
            high = t;
        }
        if (low < high) {
            mergeSort(src, low, mid);
            mergeSort(src, mid + 1, high);
            merge(src, low, mid, high);
        }
    }

    private static void merge(int[] src, int low, int mid, int high) {
        int[] result = new int[high - low + 1];
        int count = 0;
        int ilow = low;
        int hmid = mid + 1;
        while(low <= mid && hmid <= high) {
            if (src[low] > src[hmid]) {
                result[count] = src[hmid];
                hmid++;
            } else {
                result[count] = src[low];
                low++;
            }
            count++;
        }
        while(low <= mid) {
            result[count] = src[low];
            low++;
            count++;
        }
        while(hmid <= high) {
            result[count] = src[hmid];
            hmid++;
            count++;
        }
        count--;
        while(count >= 0) {
            src[count + ilow] = result[count];
            count--;
        }
    }
}
