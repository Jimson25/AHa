package demo._0107;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        testLinkedList();




    }
    public static void testLinkedList(){
        LinkedList<Integer> list = new LinkedList<>();
        ListIterator<Integer> it = list.listIterator();
        list.add(1);
        System.out.println(it.next());

    }

    public static void testHashMap() {
        Map<Integer, String> map = new HashMap<>();
        map = new LinkedHashMap<>();
        map.put(1,"haha");
        System.out.println(map.get(1));
    }
}
