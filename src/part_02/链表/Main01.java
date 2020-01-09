package part_02.链表;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * java代码实现单向链表
 */
public class Main01 {

    public static void main(String[] args) {
        //定义局部内部类表示链表的每个节点
        class Node {
            int data;
            Node next;
        }
        //链表表头
        Node head = null;
        //中间量,表示最后一个节点
        Node lastNode = null;

        while (true) {
            System.out.println("请输入要插入的整数,输入任意非整数结束：");
            int i = 0;
            try {
                i = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                break;
            }


            if (head == null) { //第一次录入数据
                //新建一个节点并为data赋值
                Node node = new Node();
                node.data = i;
                //使用临时变量引用当前输入的node的内存地址
                lastNode = node;
                //将当前节点设置为头节点
                head = node;
            } else {    //不是第一次录入数据
                //新建节点并赋值
                Node node = new Node();
                node.data = i;
                //将当前节点绑定在链表最末尾
                lastNode.next = node;
                //将当前节点设置为最末尾节点
                lastNode = node;
            }
        }

        //遍历节点输出每个值
        while (head!=null){
            System.out.printf("%d \t",head.data);
            head = head.next;
        }
        System.out.println();

    }
}
