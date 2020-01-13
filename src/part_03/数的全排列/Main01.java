package part_03.数的全排列;

import common.Utils;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 求数的全排列
 */

// TODO: 2020/1/13 看不懂
public class Main01 {
    public static void main(String[] args) {
        System.out.println("==>");
        int m = new Scanner(System.in).nextInt();
        int len = String.valueOf(m).length();
        int[] ints = Utils.intToArray(m);
//        byte[] bytes = new byte[len];
//        for (int j = 0; j < len; j++) {
//            bytes[j] = (byte) ints[j];
//        }
//        boolean[] bucket = new boolean[i];

        System.out.println(len);

    }

    public static List<String> change(int[] arr, int start, int end) {
        List<String> list = new ArrayList<>();
        if (start == end) {
            return list;
        }
        for (int i = 0; i < end - start + 1; i++) {
            for (int j = i, n = i; j < end; j++) {
                int t = arr[n];


            }
        }
        return null;
    }


}
