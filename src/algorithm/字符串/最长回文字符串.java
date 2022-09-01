package algorithm.字符串;

/**
 * ClassName: 最长回文字符串
 * Description:  给你一个字符串 s，找到 s 中最长的回文子串。
 * date: 2022/5/16 23:09
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class 最长回文字符串 {

    public String getLongestPalindrome(String s) {
        if(s == null) {
            return null;
        }
        String result = s.charAt(0) + "";
        for(int i = 1; i < s.length(); i++) {
            int res = checkChar(s, i);
            if(res != 0 && res > result.length() / 2) {
                result = s.substring(i - res, i + 1 +res);
            }
        }
        return result;
    }

    public int checkChar(String s, int index) {
        int flag = 0;
        int lIndex = index - 1;
        int rIndex = index + 1;
        char leftChar = s.charAt(lIndex);
        char rightChar = s.charAt(rIndex);
        while(leftChar == rightChar && lIndex > -1 && rIndex < s.length()) {
            flag++;
            lIndex--;
            rIndex++;
            leftChar = s.charAt(lIndex);
            rightChar = s.charAt(rIndex);
        }
        return flag;
    }

    public static void main(String[] args) {
        最长回文字符串 test = new 最长回文字符串();
        System.out.println(test.getLongestPalindrome("sdfghjklrlkjhgfds"));
    }
}
