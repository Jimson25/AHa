package part_01.课后练习;

import common.Utils;
import part_01.快速排序.Main02;

import java.util.Arrays;
import java.util.Random;

/**
 * 课后练习，冒泡排序实现
 * 输入2行
 * 第一行：正整数n，表示有n个同学参加调查（k<=100）
 * 第二行：n个空格隔开的正整数为图书的ISBN号
 * 输出2行
 * 第一行：正整数k，表示需要买多少本书
 * 第二行：k个用空格隔开的正整数，表示需要买的书的ISBN号
 * <p>
 * 生成一个ISBN数组，快速排序
 */
public class Demo02 {
    public static void main(String[] args) {
        int MAX_ISBN =1000000;
        //记录程序开始时间
        long start = System.currentTimeMillis();
        //随机生成一个70-100之间的随机数作为参与调查的同学数
        int k = new Random().nextInt(30) + 70;
        //生成一个长度为k的int数组表示参与调查的同学给定的ISBN号
        int[] ISBNs = Utils.createIntArray(k, 0, MAX_ISBN);

        //对给定的ISBN号进行排序
        Main02.quickSort(ISBNs);
        //定义一个计数变量用于记录ISBN数组中不重复的元素数量
        int count = ISBNs.length;
        //定义一个布尔数组用作重复标记
        boolean[] flag = new boolean[ISBNs.length];
        for (int i = 1; i < ISBNs.length; i++) {
            //从第二个元素开始遍历ISBN数组，如果当前元素和前一位元素相等，就讲该元素下标在标记数组对应的元素设置为true表示该位置元素存在重复
            if (ISBNs[i] == ISBNs[i - 1]) {
                //boolean数组默认值是false
                flag[i] = true;
                count--;
            }
        }
        //以ISBN数组中不重复的元素数量为长度定义一个最终数组
        int[] finalArr = new int[count];
        //遍历ISBN数组，如果当前元素对下标在flag中对应false，则表示当前元素不是重复元素，将其值保存到最终数组
        for (int i = 0, j = 0; i < ISBNs.length; i++) {
            if (!flag[i]) {
                finalArr[j] = ISBNs[i];
                j++;
            }

        }
        System.out.printf("耗时：%d ms\n", System.currentTimeMillis() - start);
        System.out.printf("共有 %d 位同学参与调查\n", k);
        System.out.printf("需要买 %d 本书\n", finalArr.length);
        System.out.printf("ISBN号分别为： %s\n", Arrays.toString(finalArr));
    }
}
