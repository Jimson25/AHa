package part_02.队列;

import java.util.Arrays;
import java.util.Random;

/**
 * 使用成员内部类替代结构体实现队列操作
 */
public class Main02 {
    public static void main(String[] args) {
        Queue queue = new Main02().new Queue();
        int[] a = new int[50];
        queue.data = a;
        queue.head = 0;
        queue.tail = 0;

        for (int i = 0;i<9;i++){
            queue.data[queue.tail] = new Random().nextInt(10);
            queue.tail++;
        }

        System.out.println(Arrays.toString(queue.data));

        while (queue.head < queue.tail) {
            System.out.printf("%d ", queue.data[queue.head]);
            queue.head++;

            queue.data[queue.tail] = queue.data[queue.head];
            queue.tail++;
            queue.head++;
        }

    }

    /**
     * 定义内部类作为结构体
     */
    class Queue {
        int[] data;
        int head;
        int tail;
    }


}
