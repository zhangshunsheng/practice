package algorithm.字符串;

/**
 * ClassName: 字符串相加
 * Description:
 * date: 2022/5/16 0:27
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class 字符串相加 {
    // 官方题解
    public String addString(String num1, String num2){
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; --i, --j) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }

    public String stringAdd(String a, String b) {
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        char[] cArray = new char[a.length() > b.length() ? a.length() : b.length()];
        int count = 0;
        int up = 0;
        while (count < a.length() && count < b.length()) {
            int num = (int)aArray[aArray.length - 1 - count] + (int) bArray[bArray.length - 1 - count] + up - 2 * '0';
            cArray[cArray.length - 1 - count] = getChar(num);
            count++;
            if(num < 10) {
                up = 0;
                continue;
            }
            up = 1;
        }
        while (count < a.length()) {
            int num = (int)aArray[aArray.length - 1 - count] + up - '0';
            cArray[cArray.length - 1 - count] = getChar(num);
            count++;
            if(num < 10) {
                up = 0;
                continue;
            }
            up = 1;
        }
        while (count < b.length()) {
            int num = (int) bArray[bArray.length - 1 - count] + up - '0';
            cArray[cArray.length - 1 - count] = getChar(num);
            count++;
            if(num < 10) {
                up = 0;
                continue;
            }
            up = 1;
        }
        if(up == 1) {
            return "1" + new String(cArray);
        }
        return new String(cArray);
    }

    public char getChar(int num) {
        char[] a = (num + "").toCharArray();
        return a[a.length - 1];
    }
    public static void main(String[] args) {
        String a = "9999";
        String b = "1";
        字符串相加 test = new 字符串相加();
        System.out.println(test.stringAdd(a, b));
    }
}
