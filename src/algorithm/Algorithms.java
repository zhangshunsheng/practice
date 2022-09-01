package algorithm;

import java.util.Arrays;

/**
 * ClassName: Algorithms
 * Description:
 * date: 2022/4/28 16:07
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class Algorithms {
    // 冒泡排序
    public static void bubbleSort(int arr[], int start, int end) {
        if(start < 0 || start >= end || end > arr.length - 1) {
            return;
        }
        for(int i = start; i <= end - 1; i++) {
            for(int j = i + 1; j <= end; j++) {
                if(arr[i] > arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        System.out.println("冒泡排序后：" + Arrays.toString(arr));
    }

    // 插入排序
    public static void insertSort(int arr[], int start, int end) {
        if(start < 0 || start >= end || end > arr.length - 1) {
            return;
        }
        for(int i = start + 1; i <= end; i++) {
            if(arr[i] < arr[i-1]) {
                swap(arr, i, i - 1);
                for(int j = i - 1; j > start; j--) {
                    if(arr[j] < arr[j-1]) {
                        swap(arr, j, j - 1);
                    }
                }
            }
        }
        System.out.println("插入排序后：" + Arrays.toString(arr));
    }

    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 选择排序
    public static void chooseSort(int arr[], int start, int end) {
        if(start < 0 || start >= end || end > arr.length - 1) {
            return;
        }
        for(int i = start; i < end; i++) {
            for(int j = i + 1; j <= end; j++) {
                if(arr[j] < arr[i]) {
                    swap(arr, i, j);
                }
            }
        }
        System.out.println("选择排序后：" + Arrays.toString(arr));
    }

    // 归并排序
    public static void mergeSort(int arr[], int start, int end) {
        if(start < 0 || start >= end || end > arr.length - 1) {
            return;
        }
        int mid = start + end >>> 1;
        if(start != mid) {
            mergeSort(arr, start, mid);
        }
        if(mid + 1 != end) {
            mergeSort(arr, mid + 1, end);
        }
        merge(arr, start, end);
    }

    public static void merge(int arr[], int start, int end) {
        int mid = start + end >>> 1;
        int temp[] = new int[end - start + 1];
        int index = 0;
        int leftStart = start;
        int rStart = mid + 1;
        do {
            if(arr[leftStart] < arr[rStart]) {
                temp[index] = arr[leftStart];
                leftStart++;
            } else {
                temp[index] = arr[rStart];
                rStart++;
            }
            index++;
        } while (leftStart <= mid && rStart <= end);

        while(leftStart <= mid) {
            temp[index] = arr[leftStart];
            leftStart++;
            index++;
        }

        while(rStart <= end) {
            temp[index] = arr[rStart];
            rStart++;
            index++;
        }
//        index--;
//        while (index > 0) {
//            arr[start + index] = temp[index];
//            index--;
//        }
        System.arraycopy(temp, 0, arr, start, end - start + 1);
    }

    // 快速排序
    public static void fastSortByFirstNum(int arr[], int start, int end) {
        if(arr.length < 2 || start < 0 || end <= start ) {
            return;
        }
        int compare = arr[start];
        int index = start;
        for(int i = start + 1; i <= end; i++) {
            // 如果数比基准数小，则把数放在现在基准数的位置，然后基准数前移一位，把原来基准数后一位的数放到现在比较的数的位置
            if(arr[i] < compare) {
                arr[index] = arr[i];
                arr[i] = arr[++index];
            }
        }
        fastSortByFirstNum(arr, start, index);
        fastSortByFirstNum(arr, ++index, end);
    }

    // 堆排序
    // 获取第K小，试想一下这个数组已经由小到大排好序，那么我们是不是把前面K个数建立成一个二叉树，然后获取这个二叉树的最大值既是第K小的数，那么堆顶的值就是最大值，也就是我们需要维护一个大根堆。
    public static void heapSort(int arr[], int k) {
        if(arr.length < k) {
            return;
        }

        // 用数组维护一个堆，若用数组下标表示，堆满足叶子节点的父节点下标为（i-1）/2, 父节点的左叶子节点为2i+1, 右叶子节点为2i+2.因此，我们可以用数组来表示一个堆
        int[] heap = new int[k];
        System.arraycopy(arr, 0, heap, 0, k);
        setupHeap(heap);
        for(int i = k; i < arr.length; i++) {
            if(arr[i] < heap[0]) {
                heap[0] = arr[i];
                heapAdjust(heap, 0);
            }
        }
        System.out.print("堆排序获取第" + k + "小的数为：" + heap[0]);
    }

    // 建堆
    public static void setupHeap(int[] arr) {
        // 既然是保持堆顶数据最大，那么我们只需要从最后一个父节点开始往上遍历，保证父节点以及左右节点的数据中父节点的数据最大就可以，这样遍历到最上面的节点就能保证堆顶的数据是最大的。从数组下标来看，最后一个父节点的下标为arr.length/2-1
        for(int i = arr.length/2 - 1; i >= 0; i--) {
            heapAdjust(arr, i);
        }
    }

    // 调整堆
    public static void heapAdjust(int[] arr, int index) {
        int parent = arr[index];
        int leftIndex = index * 2 + 1;
        // 递归退出条件，遍历的节点为叶子节点
        if(leftIndex >= arr.length) {
            return;
        }
        int rightIndex = index * 2 + 2;
        if(arr.length > rightIndex) {
            if(arr[leftIndex] > arr[rightIndex]) {
                if(parent < arr[leftIndex]) {
                    arr[index] = arr[leftIndex];
                    arr[leftIndex] = parent;
                    heapAdjust(arr, leftIndex);
                }
            } else {
                if(parent < arr[rightIndex]) {
                    arr[index] = arr[rightIndex];
                    arr[rightIndex] = parent;
                    heapAdjust(arr, rightIndex);
                }
            }
        } else {
            if(parent < arr[leftIndex]) {
                arr[index] = arr[leftIndex];
                arr[leftIndex] = parent;
                heapAdjust(arr, leftIndex);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = TestDataClass.getRandomIntData(15);
        System.out.println("未排序数据：" + Arrays.toString(arr));
        bubbleSort(Arrays.copyOf(arr, arr.length), 0, arr.length - 1);
        insertSort(Arrays.copyOf(arr, arr.length), 0, arr.length - 1);
        chooseSort(Arrays.copyOf(arr, arr.length), 0, arr.length - 1);
        int mergeSortArr[] = Arrays.copyOf(arr, arr.length);
        mergeSort(mergeSortArr, 0, arr.length - 1);
        System.out.println("归并排序后：" + Arrays.toString(mergeSortArr));
        int fastSortArr[] = Arrays.copyOf(arr, arr.length);
        fastSortByFirstNum(fastSortArr, 0, 3);
        System.out.println("快速排序后：" + Arrays.toString(mergeSortArr));
        heapSort(Arrays.copyOf(arr, arr.length), 15);
    }
}
