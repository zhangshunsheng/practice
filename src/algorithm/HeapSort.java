package algorithm;

/**
 * ClassName: HeapSort
 * Description:
 * date: 2020/12/7 0:45
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class HeapSort {
    /**
     * 从小到大排序，需要构建大顶堆
     * @param arr
     */
    public static void HeapSort(int arr[]){
        //用数组存储堆，从arr.length/2开始到后面的节点都是叶子节点
        //所以从arr.length/2 - 1 开始往前构造大顶堆
        int len = arr.length;
        for(int i = arr.length/2 - 1; i > 0;i--){
            heapAdjust(arr,i,arr.length);
        }

        //排序交换第一个元素和最后一个元素,循环n-1次
        for(int i = arr.length - 1; i > 0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapAdjust(arr,0, i);
        }
    }
    /**
     * 对于当前的parent节点（不是叶子节点），调整结构，使得满足大顶堆结构
     * @param arr
     * @param parent
     * @param length 在排序阶段，每次把堆顶元素和最后一个元素交换，把剩下的元素重新构造堆，长度每次减少1
     */
    private static void heapAdjust(int[] arr, int parent, int length) {
        int temp=arr[parent];
        // 左叶子节点，右叶子节点为 parent * 2 + 1 + 1
        int child = parent * 2 + 1;
        while(child < length){
            // 左右孩子获取较小值
            if(child + 1 < length && arr[child + 1] > arr[child]){//左右孩子比较
                child = child + 1;
            }
            // 如果父节点大于左右孩子节点则退出，否则父亲节点为较大值，并且递归向下调整
            if(temp > arr[child]){
                break;
            }
            arr[parent] = arr[child];
            parent = child;
            child = parent * 2 + 1;
        }
        // 将被调整的值放到最终位置
        arr[parent] = temp;
    }
    public static void main(String[] args) {
        int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        HeapSort(arr);
        for(int i : arr){
            System.out.print(i + "  ");
        }
    }
}