package part_03.火柴棍等式;

import common.Utils;

import java.util.Scanner;

/**
 * -------------样本--------------
 *
 * 需求:
 * ---- 玩家手中有m(m<=24)根火柴,计算出能拼出多少个A+B=C的等式
 * ---- 0-9所需的火柴分别为6,2,5,5,4,5,6,3,7,6根,拼出的元素第一位不能为0
 * ---- '+'和'='分别占用两根火柴
 * 分析:
 * ---- 假设有24根火柴,减去+=占用的4根,剩余20根,在0-9中占用火柴数最少的是1,需要两根
 * ---- 即组成等式的所有数字最多不能超过10位,也就是说ABC三个数的最大值为1111
 * ---- 即,只需要循环0-1111之间的所有数字使得ABC的位数等于m-4即可
 */

// TODO: 2020/1/13
public class Main01 {
    public static void main(String[] args) {
        System.out.println("火柴总数：");
        int m = new Scanner(System.in).nextInt();

        int count = 0;
        for (int a = 0; a <= 1111; a++) {
            for (int b = 0; b < 1111; b++) {
                int c = a + b;
                if (getCount(a) + getCount(b) + getCount(c) == m - 4) {
                    System.out.printf("%d + %d = %d\n", a, b, c);
                    count++;
                }
            }
        }

    }


    /**
     * 根据传入的数字计算该数字总共需要多少根火柴
     *
     * @param number 要计算的数字
     * @return 组成该数字共需要的火柴数量
     */
    public static int getCount(int number) {
        int count = 0;
        int[] num = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
        int[] ints = Utils.intToArray(number);
        for (int i : ints) {
            count += num[i];
        }
        return count;
    }

}
