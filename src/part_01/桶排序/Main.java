package part_01.桶排序;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 需求:
 * 将输入的数字按大到小排序，最大值为10
 * 思路：
 * 1.新建一个长度为11的数组并将每个元素的初始值设置为0
 * 2.将输入的值作为的数组下标将其对应的元素值+1
 * 3.倒序遍历数组，根据元素的值作为次数打印数组下标
 */
public class Main {

    public static void main(String[] args) {
        //用于记录输入了多少个数据
        int count = 0;
        System.out.println("请输入排序元素的最大值：");
        int maxValue = input();
        //根据限制的最大元素值创建数组
        int[] arr = new int[maxValue + 1];
        //循环输入数据，记录输入的元素个数，当遇到停止标记时结束循环
        while (true) {
            int i = input();
            if (i == -1) {
                break;
            }
            if (i < 0 || i > 10) {
                System.out.println("数据范围不合法");
                continue;
            }
            arr[i]++;
            count++;
        }
        //根据输入的元素个数创建一个数组用于保存排序后的元素
        int[] finalArr = new int[count];
        for (int i = 0, m = 0; i < arr.length; i++) {
            //从小到大统计数组中每个元素的值并根据其值将下标值保存到排序后的数组
            for (int j = 1; j <= arr[i]; j++) {
                finalArr[m] = i;
                m++;
            }
        }
        System.out.println("排序后：" + Arrays.toString(finalArr));

    }

    //键盘输入函数
    public static int input() {
        System.out.println("请输入排序元素,结束请输入-1：");
        return new Scanner(System.in).nextInt();
    }

}
