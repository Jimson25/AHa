package part_02.栈;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 通过栈判断字符串是不是回文
 * 取数组的中间元素，将中间元素之前的元素全部放到栈中
 * 当中间元素之前的元素全部放完
 * 将栈中的元素依次取出和数组的中间元素后面的元素作对比，只要有一个不相同就说明该字符串不是回文
 */
public class Main01 {
    public static void main(String[] args) {
        System.out.println("==>");
        String str = new Scanner(System.in).nextLine();
        char[] chars = str.toCharArray();
        System.out.println(Arrays.toString(chars));

        int len = chars.length;
        int mid = len / 2 - 1;
        int top = 0;
        char[] chrArr = new char[len];
        for (int i = 0; i <= mid; i++) {
            chrArr[top] = chars[i];
            top++;
        }

        int start;
        if (chars.length % 2 == 0) {
            start = mid + 1;
        } else {
            start = mid + 2;
        }

        for (int i = start; i < chars.length; i++) {
            if (chars[i] != chrArr[top-1]) {
                System.out.println("FALSE");
                return;
            }
            top--;
        }
        System.out.println("TRUE");


    }
}
