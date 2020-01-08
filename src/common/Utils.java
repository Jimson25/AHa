package common;

import java.util.Random;

public class Utils {
    /**
     * 根据给定参数生成随机数组,包含最小值不含最大值
     *
     * @param length 数组长度
     * @param min    数组元素最小值
     * @param max    数组元素最大值
     * @return 生成的随机数组
     */
    public static int[] createIntArray(int length, int min, int max) {
        if (length < 1) {
            throw new IllegalArgumentException("请输入有效的数组长度");
        } else if (min > max) {
            throw new IllegalArgumentException("请输入正确的元素最小值和最大值");
        }
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = min + new Random().nextInt(max - min);
        }
        return arr;
    }

    /**
     * 将一个int类型的整数转换为int数组，传入123返回{1,2,3}
     * @param number 要转换的数
     * @param len    要转换的数的位数
     * @return       转换后的数组
     */
    public static int[] intToArray(int number, int len) {
        //定义一个数组用于保存number的每个数字
        int[] arr = new int[len];
        int j = 0, i = 10;

        //取出number的每个数字放到数组中，此时数组中的元素是倒序的
        do {
            arr[j] = number % i;
            number /= i;
            j++;
        } while (number != 0);

        //定义一个新数组用于保存最终的qq转化的数组
        int[] a = new int[len];
        //将原先的倒序qq数组转换为正序
        for (int x = j - 1, y = 0; x >= 0; x--, y++) {
            a[y] = arr[x];
        }
        return a;
    }
}
