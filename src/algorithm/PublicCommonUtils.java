package algorithm;

/**
 * ClassName: PublicCommonUtils
 * Description: 公共工具类
 * date: 2020/11/11 12:54
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public final class PublicCommonUtils {
    public static final void swap(final int[] arrays, final int sIndex, final int eIndex) {
        int temp = arrays[sIndex];
        arrays[sIndex] = arrays[eIndex];
        arrays[eIndex] = temp;
    }
}
