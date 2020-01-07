package part_01.快速排序;

import part_01.Common.Utils;

import java.util.Arrays;

/**
 * 快速排序，小到大的顺序
 */
public class Main02 {
    public static void main(String[] args) {
        int[] a = Utils.createIntArray(20, 10, 100);
//        int[] a = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        System.out.println("原数组：");
        System.out.println(Arrays.toString(a));

        quickSort(a);

        System.out.println("排序后：");
        System.out.println(Arrays.toString(a));
    }


    public static void quickSort(int[] arr, int left, int right) {
        /*
            递归的最小值，当前一次调用时只剩下最后一个元素，此时left = right
            那么下次调用时会出现的情况是
                quickSort(arr, left, l - 1);
                quickSort(arr, l + 1, right);
            不论是哪一种情况，left 均大于 right
            即：这里会递归调用到只剩下最后一个元素为止
         */
        if (left > right) {
            return;
        }

        //确定一个基准元素，这里以数组最左边的元素作为基准数
        int base = arr[left];
        //保留初始的left和right值，后面会用到
        int l = left;
        int r = right;

        while (l != r) {
            //下面两个while循环当左边标记'l'遇到右侧标记'r'时会自动结束循环


            //右边的标记往左边找，当它没有找到比基准元素小的元素时，就会继续往右找，直到找到为止，此时下标r对应的元素值小于基准元素
            while (arr[r] >= base && l < r) {
                r--;
            }
            //左边的标记会一直往右边找，当没有找到比基准元素大的值时就继续向左找，直到找到为止此时下标r对应的元素值大于基准元素
            while (arr[l] <= base && l < r) {
                l++;
            }

            //当遇到左边的标记大于基准数且右边的标记小于基准数时才会将两个标记对应的元素值进行交换
            //这里是为了避免左右两个标记相遇时的情况
            if (l < r) {
                int t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
            }
        }

        //将l指向的元素和left对应的元素交换
        arr[left] = arr[l];
        arr[l] = base;

        //此事基准数已经换到了数组中间，左边的元素均小于基准数，右边的元素均大于基准数
        //在进行递归调用分别对基准数左边和右边的部分进行排序
        quickSort(arr, left, l - 1);
        quickSort(arr, l + 1, right);
        return;
    }

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
}
