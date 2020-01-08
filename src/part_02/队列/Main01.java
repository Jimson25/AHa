package part_02.队列;

import common.Utils;

import java.util.Arrays;

/**
 * 队列，解密QQ
 * 存在一个加密的QQ号，解密规则如下：
 * 取第一个数删除，再将第二个数放在最后面，
 * 取第三个数删除，再将第四个数放在最后面
 * 。。。
 * 直到加密的数删除完最后一个元素
 * 再按删除的顺序将删除的数组合到一起即为解密的QQ
 */
public class Main01 {
    public static void main(String[] args) {
        int QQ = 631758924;
        int[] a = Utils.intToArray(QQ, 50);

        //定义两个变量，一个指向数组a的第一个元素，一个指向数组的最后一个元素下标-1的元素
        int head = 0;
        int tail = 9;

        //定义最终的数组
        int[] arr = new int[9];

        int m = 0;
        while (head < tail) {
            //将第一个元素保存到最终数组
            arr[m] = a[head];
            //head指向下一个元素（相当于删除第一个元素）
            head++;
            //将第二个元素放到数组最后面
            a[tail] = a[head];
            //结束的下标往后移动一位
            tail++;
            //开始元素的下标移动一位
            head++;
            //最终数组下标+1
            m++;
        }
        System.out.println(Arrays.toString(arr));
    }

}
