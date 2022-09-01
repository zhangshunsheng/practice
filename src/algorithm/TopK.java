package algorithm;

/**
 * ClassName: TopK
 * Description:
 * date: 2020/12/7 0:54
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public final class TopK {
    // Top-K 问题，优先队列，堆排序，快排，BFPRT排序

    public static void main(String[] args) {
        int[] test = {88, 55, 66, 77, 3, 43, 105, 109, 101, 1005, 1005, 1008};
        System.out.println(TopK.getMaxKvalue(test,5 ));
    }

    // 小顶堆获取di第K大
    public static int getMaxKvalue(int[] src, int k) {
        if(k > src.length || k < 1)
            throw new RuntimeException("k值有误！");
        return src.length == 1 ? src[0] : getMaxKvalueByHeapSort(src, k);
    }

    private static int getMaxKvalueByHeapSort(int[] src, int k) {
        int res[] = creatMinHeap(src, k);
        for(int i = k; i < src.length; i++) {
            if(src[i] > res[0]) {
                insertHeap(res, src[i]);
            }
        }
        return res[0];
    }

    private static int[] creatMinHeap (int[] src, int k) {
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = src[i];
        }
        for(int parent = k/2; parent >= 0; parent--) {
            heapArrayAdjust(res, parent, res.length);
        }
        return res;
    }

    private static void heapArrayAdjust(int[] src, int parent, int srcLength) {
        int parentTemp = src[parent];
        int child = parent * 2 + 1;
        while (child < srcLength) {
            if(child + 1 < srcLength && src[child] > src[child + 1]) {
                child++;
            }
            if(src[parent] < src[child]) {
                break;
            }
            src[parent] = src[child];
            parent = child;
            child = parent * 2 + 1;
        }
        src[parent] = parentTemp;
    }

    private static void insertHeap(int[] src, int value) {
        src[0] = value;
        for(int parent = src.length/2; parent >= 0; parent--) {
            heapArrayAdjust(src, parent, src.length);
        }
    }


//    public static void main(String[] args) {
//        int[] arr = {88, 55, 66, 77, 3, 43, 105, 109, 101, 1005, 1005, 1008};
//        int []res= getTopK(arr,3);
//        for(int i:res){
//            System.out.println(i);
//        }
//    }

    /*
     * 创建k个元素的小顶堆
     */
    public static int[] creat(int arr[],int k){
        int res[]=new int [k];
        for(int i=0;i<k;i++){
            res[i]=arr[i];
        }
        for(int i=k/2;i>=0;i--){
            int temp=res[i];
            int child=i*2+1;
            while(child<res.length){
                if(child+1<res.length && res[child+1]<res[child]){
                    child++;
                }
                if(temp<res[child]){
                    break;
                }
                res[i]=res[child];
                i=child;
                child=child*2+1;
            }
            res[i]=temp;
        }

        return res;
    }
    private static int [] getTopK(int arr[],int k){
        int res[]=creat(arr,k);//k个元素的小顶堆
        int min=res[0];
        for(int i=k+1;i<arr.length;i++){
            if(arr[i]>min){
                insert(res,arr[i]);
            }
        }
        return res;
    }
    private static void insert(int[] res, int value) {
        res[0]=value;
        for(int i=res.length/2;i>=0;i--){
            int temp=res[i];
            int child=i*2+1;
            while(child<res.length){
                if(child+1<res.length && res[child+1]<res[child]){
                    child++;
                }
                if(temp<res[child]){
                    break;
                }
                res[i]=res[child];
                i=child;
                child=child*2+1;
            }
            res[i]=temp;
        }

    }
}