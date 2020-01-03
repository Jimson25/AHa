package part_01.冒泡排序;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 冒泡排序
 */
public class Main01 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int n = 0;
        while (true) {
            if (n >= 10)
                break;
            System.out.println("请输入排序数字：");
            arr[n] = input();
            n++;
        }
//        int[] arr = {9, 4, 2, 3, 5, 6, 1, 8, 7, 0};
        System.out.printf("初始数组：%s\n", Arrays.toString(arr));
        for (int i = arr.length - 1, m = 1; i > 0; m++, i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
            System.out.printf("第%d次排序后：%s\n", m, Arrays.toString(arr));
        }
    }

    public static int input() {
        return new Scanner(System.in).nextInt();
    }
}
