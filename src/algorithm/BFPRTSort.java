package algorithm;

import java.util.Arrays;

/**
 * ClassName: BFPRTSort
 * Description:
 * date: 2020/12/6 23:22
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class BFPRTSort {

    public static void main(String[] args) {
        int data[] = {
                2,5,6,8,7,
                8,5,2,0,1,
                10,22,45,84,9,
                7,54,56,102,105,
                54,55,23,41,98,
                100,99,98,97
        };
        System.out.println(BFPRTSort.getMinKthNum(data, 10));
        System.exit(0);
    }

    // O(N)的解法
    public static int getMinKthNum(int[] arr, int k){
        if(arr==null||k>arr.length){
            return Integer.MIN_VALUE;
        }
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        return BFPRT(copyArr, 0, arr.length-1, k-1);
    }

    private static int[] partition(int[] arr, int begin, int end, int pivot){
        // L标记比基准值pivot小的最大下标，在L以及L之前的数均比pivot小，R反之
        int L = begin-1;
        int R = end + 1;
        int cur = begin;
        while(cur!=R){
            if(arr[cur]>pivot){
                swap(arr, cur, --R);
            } else if(arr[cur]<pivot){
                swap(arr, cur++, ++L);
            } else{
                // L始终等于cur,直到遇到与基准值pivot一致的数则L不做操作，cur++
                cur++;
            }
        }
        // L+1 至 R-1的区间内的数均等于基准值pivot
        return new int[]{L+1, R-1};
    }

    private static int BFPRT(int[] arr, int begin, int end, int i) {
        if (begin == end) {
            return arr[begin];
        }
        int pivot = medianOfMedians(arr, begin, end);
        int[] pivotRange = partition(arr, begin, end, pivot);
        if(i>=pivotRange[0]&&i<=pivotRange[1]){
            return arr[i];
        } else if(i<pivotRange[0]){
            return BFPRT(arr, begin, pivotRange[0]-1, i);
        } else{
            // 传入的数组还是原始数组arr,并不是通过begin跟end下标截取后的数组，所以，i的值不变
            return BFPRT(arr, pivotRange[1] + 1, end, i);
        }
    }

    private static int medianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] medians = new int[num / 5 + offset];
        for (int i = 0; i < medians.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            medians[i] = getMedian(arr, beginI, Math.min(endI, end));
        }
        // 通过BFBRT算法取中位数值
        return BFPRT(medians, 0, medians.length - 1, medians.length / 2);
    }

    private static int getMedian(int[] arr, int begin, int end){
        insertionSort(arr, begin, end);
        int sum = end + begin;
        int mid = (sum/2) + (sum%2);
        return arr[mid];
    }

    private static void insertionSort(int[] arr, int begin, int end){
        if(begin>=end){
            return;
        }
        for(int i=begin+1;i<=end;i++){
            for(int j=i;j>begin;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr, j, j-1);
                } else{
                    break;
                }
            }
        }
    }

    private static void swap(int[]arr , int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }




    /**
     * 获取数组中第K大元素，返回该元素
     * @param arr
     * @param sIndex
     * @param eIndex
     * @param k
     * @return
     */
    public int getTopKValue(int[] arr, int sIndex, int eIndex, int k) {
        if (eIndex > sIndex || sIndex < 0 || eIndex > arr.length || k > eIndex - sIndex + 1)
            throw new RuntimeException("输入不合法！");
        if (sIndex == eIndex && k == 1)
            return arr[sIndex];
        // 获取第K大元素，转换成下标则-1。
        return selectKValue(arr, sIndex, eIndex, --k);
    }

    /**
     * 获取数组中前K大元素
     * @param arr
     * @param sIndex
     * @param eIndex
     * @param k
     * @return
     */
    public int[] getTopKArray(int[] arr, int sIndex, int eIndex, int k) {
        return null;
    }

    /**
     *
     * @param arr
     * @param sIndex
     * @param eIndex
     * @param k
     * @return
     */
    private int selectKValue(int[] arr, int sIndex, int eIndex, int k) {
        int a = (eIndex - sIndex) % 5 == 0 ? 0 : 1;
        int midArray[] = new int[arr.length / 5 + a];
        int tempsIndex = sIndex;
        int count = 0;
//        while(tempsIndex < eIndex) {
//            int tempeIndex = tempsIndex + 5 > eIndex ? eIndex : tempsIndex + 5;
//            midArray[count] = getMedian(arr, )
//        }
        return 0;
    }
}
