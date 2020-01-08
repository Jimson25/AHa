package part_01.练习demo;

import common.Utils;

import java.util.Arrays;
import java.util.Random;

/**
 * 输入2行
 * 第一行：正整数n，表示有n个同学参加调查（k<=100）
 * 第二行：n个空格隔开的正整数为图书的ISBN号
 * 输出2行
 * 第一行：正整数k，表示需要买多少本书
 * 第二行：k个用空格隔开的正整数，表示需要买的书的ISBN号
 */
public class Demo {
    public static void main(String[] args) {
        //定义一个变量表示要购买的书的最大ISBN号
        int MAX_ISBN = 100000;
        //开始时间
        long start = System.currentTimeMillis();
        //随机生成一个70-100之间的随机数作为参与调查的同学数
        int k = new Random().nextInt(30) + 70;
        //生成一个长度为k的int数组表示参与调查的同学给定的ISBN号
        int[] ISBNs = Utils.createIntArray(k, 0, MAX_ISBN);

        int[] distinctISBN = bucketSort(ISBNs, MAX_ISBN);
        Long time = System.currentTimeMillis() - start;
        System.out.printf("耗时：%d ms\n", time);
        System.out.printf("共有 %d 位同学参与调查\n", k);
        System.out.printf("需要买 %d 本书\n", distinctISBN.length);
        System.out.printf("ISBN号分别为： %s\n", Arrays.toString(distinctISBN));

    }

    public static int[] bucketSort(int[] arr, int max) {
        //根据传入的数组的最大元素值定义一个桶用作排序
        int[] bucket = new int[max];
        //定义一个统计变量用于计数桶中存在多少个元素
        int count = 0;

        //遍历给定的数组元素，将元素对应的桶数组的下标设置为1表示该ISBN对应的书籍已经统计过，桶元素数量+1
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            if (bucket[a] == 0) {
                bucket[a] = 1;
                count++;
            }
        }
        //定义一个最终的数组，将桶中的每个不为0的元素对应的下标保存到该数组中
        int[] finalArr = new int[count];
        for (int i = 0, j = 0; i < bucket.length; i++) {
            if (bucket[i] == 1) {
                finalArr[j] = i;
                j++;
            }
        }
        return finalArr;
    }


}
