package part_02.链表;

import java.util.Random;

/**
 * 参考LinkedList模拟双向链表
 * @param <E>
 */
public class Main02_plus<E> {

    private Node<E> last;
    private Node<E> first;
    private int size = 0;

    //清空
    void clear() {
        last = null;
        first = null;
        size = 0;
    }

    //删除指定
    E remove(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> node = first;
        Node<E> before = null;

        for (int i = 0; i < index; i++) {
            before = node;
            node = node.tail;
        }
        E e = node.data;
        before.tail = node.tail;
        node.tail.head = before;
        size--;
        return e;
    }

    //显示全部
    void show() {
        Node<E> t = first;
        while (t != null) {
            System.out.print(t.data + "\t");
            t = t.tail;
        }
        System.out.println();
    }

    //获取数据之情位置的
    E getNode(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<E> node = first;
        E e = null;
        for (int i = 0; i <= index; i++) {
            e = node.data;
            node = node.tail;
        }
        return e;
    }

    //添加数据
    boolean addLast(E e) {
        //每次新增节点时就使用一个变量保存之前的最后一个节点
        final Node<E> before = last;
        //创建一个新节点，将其头节点连接到上一个节点
        Node<E> node = new Node<>(before, e, null);
        //将当前节点设置为末尾节点
        last = node;

        //如果该节点之前的节点为null,即该节点时添加的第一个节点
        if (before == null) {
            //将当前节点标记为链表的第一个节点;
            first = node;
        } else {
            //当前节点不是第一个添加的节点,就将上一节点的尾结点连接到当前节点
            before.tail = node;
        }
        //计数+1
        size++;
        return true;
    }

    private static class Node<E> {
        E data;         //数据
        Node<E> head;   //上一个节点
        Node<E> tail;   //下一个节点

        public Node(Node<E> head, E data, Node<E> tail) {
            this.data = data;
            this.head = head;
            this.tail = tail;
        }
    }

    public static void main(String[] args) {
        Main02_plus<Integer> plus = new Main02_plus();
        for (int i = 0; i < 10; i++) {
            int x = new Random().nextInt(100);
            System.out.print(x + "\t");
            plus.addLast(x);
        }
        System.out.println();
        plus.show();
        System.out.println(plus.getNode(2));
        System.out.println(plus.remove(2));
        plus.show();
        plus.clear();
        System.out.println("------- clear -------");
        plus.addLast(12);
        plus.show();
    }

}
