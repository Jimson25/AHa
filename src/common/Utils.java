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
        if (length < 1 ) {
            throw new IllegalArgumentException("请输入有效的数组长度");
        }else if ( min > max){
            throw new IllegalArgumentException("请输入正确的元素最小值和最大值");
        }
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = min + new Random().nextInt(max - min);
        }
        return arr;
    }
}
