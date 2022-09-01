package other;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ClassName: test
 * Description:
 * date: 2022/5/12 17:23
 *
 * @author ZhangShunsheng
 * @since JDK 1.8
 */
public class test {

    /**
     * 输入一个非负整数，将每位数字用数组存起来，然后加一，输出数组，位与位之间用逗号链接
     */
    public static void inputNumToChar() {
        while (true) {
            Scanner sc = new Scanner(System.in);
            int inputNum = sc.nextInt();
            String temp = inputNum + "";
            char[] inputString = new char[temp.length()];
            temp.getChars(0, temp.length(), inputString, 0);
            boolean flag = true;
            int index = inputString.length - 1;
            while (true) {
                if(index == -1) {
                    char[] newInputString = new char[inputString.length + 1];
                    newInputString[0] = '1';
                    System.arraycopy(inputString, 0, newInputString, 1, inputString.length);
                    inputString = newInputString;
                    break;
                }
                if(inputString[index] < '9') {
                    inputString[index] = ++inputString[index];
                    break;
                }
                inputString[index] = '0';
                index--;
            }
            for(int i = 0; i < inputString.length; i++) {
                System.out.print(inputString[i]);
                if(i != inputString.length - 1) {
                    System.out.print(',');
                }
            }
        }
    }

    /**
     * 将一个数分解成质数相乘，由小到大排列
     */
    public static void deliverNum() {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        ArrayList wei = new ArrayList<Integer>();
        int start = 2;
        while (num != 1) {
            for(int i = start; i < num; i++) {
                if(num % i == 0) {
                    wei.add(i);
                    break;
                }
            }
        }
        System.out.println(num + " = " + wei.toString());
    }

    /**
     * 一块钱买一瓶啤酒，两个空瓶可以换一瓶啤酒，问能喝多少瓶? 递归实现
     * @param n
     * @return
     */
    public int getBearNum(int n) {
        if(n / 2 > 0) {
            return (n - n%2) + getBearNum(n /2 + n%2);
        }
        return n;
    }

    /**
     * 输入一个正整数，返回距离他最近的对称数。
     * @param num
     * @return
     */
    public static int getNearSymNum(int num) {
        int downNum = num;
        int upNum = num;
        while(downNum > 0) {
            --downNum;
            if(checkNum(downNum)) {
                break;
            }
        }
        while(upNum < Integer.MAX_VALUE) {
            upNum++;
            if(checkNum(upNum)) {
                break;
            }
        }
        if(upNum == Integer.MAX_VALUE || downNum == num) {
            return upNum == Integer.MAX_VALUE ? downNum : upNum;
        }
        return upNum - num > num - downNum ? downNum : upNum - num == num - downNum ? -(upNum - num) : upNum ;
    }

    public static boolean checkNum(int num) {
        String numString = num + "";
        char[] numArray = numString.toCharArray();
        for(int i = 0; i <= (numArray.length - 1) / 2; i++) {
            if(numArray[i] != numArray[numArray.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public void changeMethod(String b) {
        b = new String("bcd");
    }
    public void changeMethod(String[] b) {
        b[0] = new String("bcd");
    }
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int input = sc.nextInt();
//        ArrayList wei = new ArrayList<Integer>();
//        int start = 2;
//        int num = input;
//        while (num != 1) {
//            for(int i = start; i <= num; i++) {
//                if(num % i == 0) {
//                    num = num / i;
//                    wei.add(i);
//                    start = i;
//                    break;
//                }
//            }
//        }
//        System.out.println(num + " = " + wei.toString());
//        while (true) {
//            Scanner sc = new Scanner(System.in);
//            int num = sc.nextInt();
//            int result = getNearSymNum(num);
//            if(result < 0) {
//                System.out.println("距离" + num + "最近的对称数为：" + (num + result) + "、" + (num - result));
//            } else {
//                System.out.println("距离" + num + "最近的对称数为：" + result);
//            }
//        }

        char u = '5';
        char s = '3';
        System.out.println(u + s);
        String a = "abc";
        new test().changeMethod(a);
        a = new String("888");
        String[] testString = {"asd", "bxd"};
        new test().changeMethod(testString);
        System.out.println(testString[0]);
    }
}
