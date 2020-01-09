package part_02.链表;

import java.util.Scanner;

/**
 * java实现双向链表（泛型）
 * 感觉这代码有点问题但是又找不到哪里有问题
 */
public class Main02 {
    public static void main(String[] args) {
        //定义一个头节点和临时节点
        Node<Integer> first = null;
        Node<Integer> before = null;

        //定义尾结点并将其下一节点链接到头节点
        Node<Integer> last = new Node<>();
        last.tail = first;

        while (true) {
            System.out.println("请输入要插入的整数,输入任意非整数结束：");
            Integer i = 0;
            try {
                i = new Integer(new Scanner(System.in).nextLine());
            } catch (NumberFormatException e) {
                break;
            }

            if (first == null) {    //这是第一个节点
                Node<Integer> node = new Node<>();
                node.data = i;
                node.tail = null;   //该节点的尾结点无数据
                node.head = last;   //该节点的头节点连接到尾结点

                first = node;       //将该节点设置为头节点
                before = node;      //将该节点赋值到临时节点

            } else {                //该节点不是第一个节点
                Node<Integer> node = new Node<>();
                before.tail = node; //将上一节点的尾结点设置为当前节点

                node.data = i;
                node.head = before; //将当前节点的前一节点设置为上一临时节点
                node.tail = first;  //将当前节点的尾结点连接到链表的头节点

                before = node;      //将当前节点保存到临时节点
            }
        }
        Node t = first;
        while (t != null) {
            System.out.print(t.data + "\t");
            t = t.tail;
            if (t == first) {
                break;
            }
        }
        System.out.println();
    }

    public static <T>void init(T t){
        Node<T> node = new Node<>();
        new Node<>();
        node.head = new Node<>();

    }
}

class Node<T> {
    T data;
    Node<T> head;
    Node<T> tail;
}
