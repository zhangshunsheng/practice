package algorithm;

import java.util.Arrays;

/**
 * ClassName: TopKProgamSolve
 * Description: TopK 问题求解的几种解法
 *      快速排序
 *      堆排序
 *      选择排序
 *      BFPRT排序
 * date: 2020/12/12 10:35
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class TopKProgamSolve<T extends Number> {
        public static void main(String[] args) {
            Integer testIntArray[] = {
                    26, 100, 23, -1,
                    20, 19, 18, 101, 16,
                    103, 19, 18, 17, 102,
                    25, 24, 105, 22, 21,
                    15, 14, 13, 12, 11,
                    10, 9,  8,  104,  6,
                    5,  4,  3,  2,  1
            };
            int startIndex = 0;
            int endIndex = testIntArray.length;
            int k = testIntArray.length - 1;
            if(testIntArray.length < 1 || startIndex < 0 || endIndex < startIndex || k > endIndex - startIndex || testIntArray.length < endIndex || k < 1)
                throw new RuntimeException("输入有误！");
		    System.out.println(TopKProgamSolve.getTopKValueByBFPET(testIntArray, startIndex, endIndex, k));
            System.out.println(TopKProgamSolve.getTopKValueByQuickSort(testIntArray, startIndex, endIndex, k));
            System.out.println(TopKProgamSolve.getTopKValueByHeapSort(testIntArray, startIndex, endIndex, k));
            System.out.println(TopKProgamSolve.getTopKValueByChooseSort(testIntArray, startIndex, endIndex, k));
        }

        public static <T extends Number> T getTopKValueByChooseSort(T[] src, int start, int end, int k) {
            if(start == end && k == 1)
                return src[start];
            T newArray[] = Arrays.copyOfRange(src, start, end);
            T result = chooseSort(newArray, 0, newArray.length, k);
            return result;
        }

        public static <T extends Number> T chooseSort(T[] src, int start, int end, int k) {
            int index = 0;
            while(index < k) {
                for(int i = index; i < end; i++) {
                    if(src[i].doubleValue() >  src[index].doubleValue()) {
                        swap(src, i, index);
                    }
                }
                index++;
            }
            return src[--k];
        }

        public static <T extends Number> T  getTopKValueByHeapSort(T[] src, int start, int end, int k) {
            if(start == end && k == 1)
                return src[start];
            T newArray[] = Arrays.copyOfRange(src, start, end);
            T result = heapSort(newArray, 0, newArray.length, k);
            return result;
        }

        /**
         * 堆排序取Top-K值，建立大根堆.
         * @param src
         * @param start
         * @param end
         * @param k
         * @return
         */
        private static <T extends Number> T  heapSort(T[] src, int start, int end, int k) {
            T[] heapArray = creatMaxHeap(src, start, k);
            for(int i = start + k; i < end; i++) {
                if(src[i].doubleValue() > heapArray[0].doubleValue()) {
                    insertHeap(heapArray, src[i]);
                }
            }
            // 获取K个最大的值并从小到大排序
            T[] newMinArray = Arrays.copyOf(heapArray, k);
            if(k > 1) {
                for(int d = 1; d < k; d++) {
                    T[] newTemp = creatMaxHeap(newMinArray, d, k - d);
                    for(int i = d; i < k; i++) {
                        newMinArray[i] = newTemp[i - d];
                    }
//				heapAdjust(newMinArray, d, k - d);
                }
            }

            // 获取K个最大的值并从大到小排序
            T[] newMaxArray = Arrays.copyOf(heapArray, k);
            if(k > 1) {
                k--;
                for(int i = 0; i < k; i++) {
                    swap(newMaxArray, 0, k - i);
                    heapAdjust(newMaxArray, 0, k - i);
                }
            }
            return heapArray[0];
        }

        /**
         * 创建大根堆.
         * @param src
         * @param start
         * @param length
         * @return
         */
        private static <T extends Number> T[] creatMaxHeap(T[] src, int start, int length) {
            T heapArray[] = (T[]) new Number[length];
            for (int i = start; i < start + length; i++) {
                heapArray[i - start] = src[i];
            }
            // 下标值从length/2开始往后的数都是叶子节点
            for(int i = length/2 - 1; i >= 0; i--) {
                heapAdjust(heapArray, i, length);
            }
            return heapArray;
        }

        private static <T extends Number> void heapAdjust(T[] src, int i, int length) {
            int parent = i;
            int son = parent * 2 + 1;
            while (son < length) {
                if(son + 1 < length && src[son].doubleValue() > src[son + 1].doubleValue())
                    ++son;
                if(src[parent].doubleValue() <= src[son].doubleValue())
                    break;
                swap(src, parent, son);
                parent = son;
                son = parent * 2 + 1;
            }
        }

        private static <T extends Number>void insertHeap(T[] heapArray, T value) {
            heapArray[0] = value;
            heapAdjust(heapArray, 0, heapArray.length);
        }

        public static <T extends Number> T getTopKValueByQuickSort(T[] src, int start, int end, int k) {
            if(start == end && k == 1)
                return src[start];
            T newArray[] = Arrays.copyOfRange(src, start, end);
            T result = quickSort(newArray, 0, newArray.length, k - 1);
            return result;
        }

        /**
         * 快速排序.
         * @param src
         * @param start
         * @param end
         * @param k
         * @return
         */
        private static <T extends Number> T quickSort(T[] src, int start, int end, int k) {
            // 取第一个数作为基准值
            T temp = src[start];
            int R = end - 1;
            int cur = start;
            while (cur < R) {
                if (src[R].doubleValue() < temp.doubleValue()) {
                    R--;
                } else {
                    src[cur] = src[R];
                    src[R] = src[++cur];
                }
            }
            src[cur] = temp;
            if (k < cur) {
                return quickSort(src, start, cur, k);
            } else if (k == cur) {
                return src[k];
            } else {
                return quickSort(src, ++cur, end, k);
            }
        }

        /**
         * 返回src中从start 至 end 范围内的数的第k大的数.
         * @param src 原数组
         * @param start 数组起始下标
         * @param end 数组结束下标
         * @param k 将第K大转换成数组对应下标，例：第6大，k = 5
         * @return
         */
        public static <T extends Number> T getTopKValueByBFPET(T[] src, int start, int end, int k) {
            if(start == end && k == 1)
                return src[start];
            T newArray[] = Arrays.copyOfRange(src, start, end);
            T result = BFPRT(newArray, 0, newArray.length, k - 1);
            return result;
        }

        /**
         * 求出数组中第k大的数, 中位数 + 快排思想.
         * 步骤：
         * 	1、求到中位数
         * 	2、partition
         * 	3、判断k值与partition后得到的中位数比较
         * 	4、k小于最小范围则利用本函数递归返回左边的值，大于则递归返回右边的
         * @param src
         * @param start
         * @param end
         * @param k
         * @return
         */
        private static <T extends Number> T BFPRT(T[] src, int start, int end, int k) {
            // 1、求中位数
            T medium = getMediumOfArray(src, start, end);
            int[] pArray = partition(src, start, end, medium);
            if(k >= pArray[0] && k <= pArray[1]) {
                return src[k];
            } else if(k < pArray[0]) {
                return BFPRT(src, start, pArray[0], k);
            } else {
                return BFPRT(src, pArray[1] + 1, end, k);
            }
        }

        /**
         * 根据基准值快速排序.
         * @param src
         * @param start
         * @param end
         * @param reference 基准值
         * @return
         */
        private static <T extends Number> int[] partition(T[] src, int start, int end, T reference) {
            if(end - start < 2) {
                return  new int[]{start, start};
            }
            int L = start - 1;
            int R = end;
            int cur = start;
            while(cur < R) {
                if(src[cur].doubleValue() > reference.doubleValue()) {
                    swap(src, ++L, cur++);
                } else if(src[cur] == reference) {
                    cur++;
                } else {
                    swap(src, --R, cur);
                }
            }

            return new int[]{++L, --R};
        }

        /**
         * 求中位数。
         * @param src
         * @param start
         * @param end
         * @return
         */
        private static <T extends Number> T getMediumOfArray(T[] src, int start, int end) {
            if(end - start < 2) {
                return src[start];
            }
            int offset = (end - start) % 5 == 0 ? 0 : 1;
            T[] mediams = (T[]) new Number[(end - start)/5 + offset];
            int countMidIndex = 0;
            int cur = start;
            while(cur < end) {
                int tempEnd = cur + 5 > end ? end : cur + 5;
                mediams[countMidIndex] = getMiediumByInsertSort(src, cur, tempEnd);
                cur += 5;
                countMidIndex++;
            }
            return BFPRT(mediams, 0, mediams.length, mediams.length/2);
        }

        /**
         * 插入排序返回中位数
         * @param src
         * @param start
         * @param end
         * @return
         */
        private static <T extends Number> T getMiediumByInsertSort(T[] src, int start, int end) {
            if(start == end || end - start == 1 || src.length == 1) {
                return src[start];
            }
            for(int i = start + 1; i < end; i++) {
                for(int j = i; j > start; j--) {
                    if(src[j].doubleValue() >= src[j - 1].doubleValue())
                        break;
                    swap(src, j, j - 1);
                }
            }
            return src[(end - 1 - start)/2 + start];
        }

        private static <T> void swap(T[] src, int i, int j) {
            T temp = src[i];
            src[i] = src[j];
            src[j] = temp;
        }
}
