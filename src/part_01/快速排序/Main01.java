package part_01.快速排序;


import common.Utils;

import java.util.Arrays;


/**
 * 快速排序：
 * 1、在数组中选一个数作为基准数
 * 2、在数组中将所有比基准数大的数组放在基准数的右边，比基准数小的数放在基准数的左边
 * 快速排序代码实现
 *
 * 快速排序，大到小
 */
public class Main01 {
    public static void main(String[] args) {
        int[] array = Utils.createIntArray(20, 10, 100);
        System.out.println("原数组：");
        System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println("排序后：");
        System.out.println(Arrays.toString(array));
    }


    public static void quickSort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }
        int temp, l, r;
        temp = a[left];
        l = left;
        r = right;
        while (l != r) {
            //j从右往左找比基准数小的元素，当对应元素比基准数大i还在j的左边时继续循环往左找
            while (a[r] <= temp && l < r) {
                r--;
            }
            while (a[l] >= temp && l < r) {
                l++;
            }
            if (l < r) {
                int t = a[l];
                a[l] = a[r];
                a[r] = t;
            }
        }
        a[left] = a[l];
        a[l] = temp;
        quickSort(a, left, l - 1);
        quickSort(a, l + 1, right);
        return;
    }


}
