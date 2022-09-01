package algorithm;

/**
 * ClassName: AlgorithmsSout
 * Description: 算法准确性以及运行时间、运行耗费内存计算输出封装类.
 * date: 2020/11/9 23:38
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public final class AlgorithmsSout {

    public static final int EASY_NUM = 20;
    public static final int COMPLEX_NUM = 100000;

    /**
     * 冒泡排序
     */
    public static final void bubbleSort() {
        soutStart("冒泡排序");
        final int[] intArray = TestDataClass.getRandomIntData(EASY_NUM);
        soutArrayData(intArray);
        System.out.println("排序后数据：");
        final int[] newIntArray = BubbleSort.bubbleSortAlgorithms(intArray);
        soutArrayData(newIntArray);
        soutEnd();
        final int[] intBArray =TestDataClass.getRandomIntData(COMPLEX_NUM);
        final long startTime = System.currentTimeMillis();
        System.gc();
        final long startMemory = Runtime.getRuntime().freeMemory();
        BubbleSort.bubbleSortAlgorithms(intBArray);
        final long endTime = System.currentTimeMillis();
        final long endMemory = Runtime.getRuntime().freeMemory();
        System.out.println("测试数据总数：" + COMPLEX_NUM + "； 排序运行时间："
                + (endTime - startTime) + "毫秒； 排序所耗内存：" + (startMemory - endMemory) + "字节");
        System.out.println();
        System.gc();
    }

    /**
     * 普通快排
     */
    public static final void commonQuickSort() {
        soutStart("普通快速排序");
        final int[] intArray = TestDataClass.getRandomIntData(EASY_NUM);
        soutArrayData(intArray);
        System.out.println("排序后数据：");
        QuickSort.commonQuickSortAlgorithms(intArray, 0, (EASY_NUM - 1));
        soutArrayData(intArray);
        soutEnd();
        final int[] intBArray =TestDataClass.getRandomIntData(COMPLEX_NUM);
        final long startTime = System.currentTimeMillis();
        System.gc();
        final long startMemory = Runtime.getRuntime().freeMemory();
        QuickSort.commonQuickSortAlgorithms(intBArray, 0, (COMPLEX_NUM - 1));
        final long endTime = System.currentTimeMillis();
        final long endMemory = Runtime.getRuntime().freeMemory();
        System.out.println("测试数据总数：" + COMPLEX_NUM + "； 排序运行时间："
                + (endTime - startTime) + "毫秒； 排序所耗内存：" + (startMemory - endMemory) + "字节");
        System.out.println();
        System.gc();
    }

    /**
     * 归并排序
     */
    public static final void mergeSort() {
        soutStart("归并排序");
        final int[] intArray = TestDataClass.getRandomIntData(EASY_NUM);
        soutArrayData(intArray);
        System.out.println("排序后数据：");
        MergeSort.mergeSort(intArray, 0, (EASY_NUM - 1));
        soutArrayData(intArray);
        soutEnd();
        final int[] intBArray =TestDataClass.getRandomIntData(COMPLEX_NUM);
        final long startTime = System.currentTimeMillis();
        System.gc();
        final long startMemory = Runtime.getRuntime().freeMemory();
        MergeSort.mergeSort(intBArray, 0, (COMPLEX_NUM - 1));
        final long endTime = System.currentTimeMillis();
        final long endMemory = Runtime.getRuntime().freeMemory();
        System.out.println("测试数据总数：" + COMPLEX_NUM + "； 排序运行时间："
                + (endTime - startTime) + "毫秒； 排序所耗内存：" + (startMemory - endMemory) + "字节");
        System.out.println();
        System.gc();
    }

    /**
     * 选择排序
     */
    public static final void chooseSort() {
        soutStart("选择排序");
        final int[] intArray = TestDataClass.getRandomIntData(EASY_NUM);
        soutArrayData(intArray);
        System.out.println("排序后数据：");
        ChooseSort.chooseSort(intArray, 0, (EASY_NUM - 1));
        soutArrayData(intArray);
        soutEnd();
        final int[] intBArray =TestDataClass.getRandomIntData(COMPLEX_NUM);
        final long startTime = System.currentTimeMillis();
        System.gc();
        final long startMemory = Runtime.getRuntime().freeMemory();
        ChooseSort.chooseSort(intBArray, 0, (COMPLEX_NUM - 1));
        final long endTime = System.currentTimeMillis();
        final long endMemory = Runtime.getRuntime().freeMemory();
        System.out.println("测试数据总数：" + COMPLEX_NUM + "； 排序运行时间："
                + (endTime - startTime) + "毫秒； 排序所耗内存：" + (startMemory - endMemory) + "字节");
        System.out.println();
        System.gc();
    }

    /**
     * 插入排序
     */
    public static final void insertSort() {
        soutStart("插入排序");
        final int[] intArray = TestDataClass.getRandomIntData(EASY_NUM);
        soutArrayData(intArray);
        System.out.println("排序后数据：");
        InsertSort.insertSort(intArray, 0, (EASY_NUM - 1));
        soutArrayData(intArray);
        soutEnd();
        final int[] intBArray =TestDataClass.getRandomIntData(COMPLEX_NUM);
        final long startTime = System.currentTimeMillis();
        System.gc();
        final long startMemory = Runtime.getRuntime().freeMemory();
        InsertSort.insertSort(intBArray, 0, (COMPLEX_NUM - 1));
        final long endTime = System.currentTimeMillis();
        final long endMemory = Runtime.getRuntime().freeMemory();
        System.out.println("测试数据总数：" + COMPLEX_NUM + "； 排序运行时间："
                + (endTime - startTime) + "毫秒； 排序所耗内存：" + (startMemory - endMemory) + "字节");
        System.out.println();
        System.gc();
    }

    public static final void soutArrayData(final int[] arrayData) {
        int count = 0;
        for (int i = 0; i < arrayData.length; i++) {
            if (count < 10) {
                count++;
                System.out.print(arrayData[i]);
                if (i < arrayData.length - 1) {
                    System.out.print("、");
                } else {
                    System.out.println();
                }
                continue;
            }
            count = 1;
            System.out.println();
            System.out.print(arrayData[i] + "、");
        }
    }

    public static final void soutStart(final String algorithmType) {
        System.out.println(algorithmType + "示例：");
        System.out.println("int类型简单测试数据：");
        System.out.println("原数据：");
    }

    public static final void soutEnd() {
        System.out.println("int类型简单测试数据结束。");
        System.out.println("int类型大数量排序时间空间计算开始：");
    }



    }
}
