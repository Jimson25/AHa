package part_04.深度优先搜索;

import java.util.Scanner;

public class Main01 {

    static int[] a = new int[10];
    static int[] book = new int[10];
    static int n;


    public static void main(String[] args) {
        System.out.println("==>");
        n = new Scanner(System.in).nextInt();

        dfs(1);

    }

    public static void dfs(int step) {
        if (step == n + 1) {
            for (int i = 1; i <= n; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
            return;
        }

        //简单点理解就是把当前手上还剩下的数字从最小的开始往后排
        for (int i = 1; i <= n; i++) {
            if (book[i] == 0) { //当前的数字没用上
                a[step] = i;    //把手上最小的数放到目标数组中
                book[i] = 1;    //标记上一步添加的数已经被使用了

                /*
                    step相当于盒子的位置,相当于顺序访问所有的盒子
                    当走到最后一个盒子时，表示这次排列结束，打印数组a的元素（相当于把盒子的牌取出来展示）
                    假设目标数字是1 2 3，那么第一次打印的数就是123,
                    此时最后一层递归调用结束执行 book[i] = 0; 即将上次设置的数设置为未占用，即设置3为未占用
                    再继续循环，此时循环结束，当前递归结束程序回到i=2时的递归调用
                 */
                //下一步
                dfs(step + 1);  //递归调用填入下一位数,直到最后一位
                book[i] = 0;    //这里是在递归方法后面,所以相当于上一组排列已经产生,这里将所有的元素全部设置为未占用等待下一次递归
            }
        }
        return;

    }
}
