package part_02.纸牌游戏;

/**
 * 纸牌游戏
 * 规则：
 * 将一副纸牌分成两份，两个玩家各一份
 * 玩家1和玩家2依次取出手中最上面一张牌放在桌子上
 * 当玩家打出的牌和桌面上的某张牌牌面相同时即可将相同两张牌和中间所夹的牌收走放在手中牌组的最下面
 * 当任一玩家手牌数量出完时游戏结束，对手获胜；
 * <p>
 * 需求：
 * 假设小哼手中有6张牌，顺序为2,4,1,2,5,6
 * 小哈也有6张牌，顺序为3,1,3,5,6,4
 * 通过程序判断谁会获胜
 * <p>
 * 实现：
 * 1、创建一个栈模拟桌面的牌
 * 2、创建两个队列分别表示玩家p1和玩家p2的手牌
 * 3、每次出牌时：
 * 1.删除出牌玩家手牌的第一个元素
 * 2.判断桌面上（栈）是否有和打出的牌牌面相同的元素
 * 有：将相同牌面中间所有的牌放到出牌玩家对应的队列最后面，在栈中删除对应元素
 * 无：将打出的牌添加到栈中
 * 4、当两个玩家中有一个的手牌为空时游戏结束
 */
public class Main01 {
    public static void main(String[] args) {
        //玩家1
        Queue p1 = new Main01().new Queue();
        //玩家2
        Queue p2 = new Main01().new Queue();
        //桌面
        Stack desk = new Main01().new Stack();

        //玩家1初始化
        int[] arr1 = {2, 4, 1, 2, 5, 6};
        for (int i = 0; i < arr1.length; i++) {
            p1.data[i] = arr1[i];
        }
        p1.head = 0;
        p1.tail = arr1.length;
        p1.name = "小哼";
        //玩家2初始化
        int[] arr2 = {3, 1, 3, 5, 6, 4};
        for (int i = 0; i < arr2.length; i++) {
            p2.data[i] = arr2[i];
        }
        p2.head = 0;
        p2.tail = arr2.length;
        p2.name = "小哈";
        //桌面初始化
        desk.data = new int[10];
        for (int i = 0; i < desk.data.length; i++) {
            desk.data[i] = -1;
        }
        desk.top = 0;

        //定义一个数组表示桌面上的纸牌，下标表示牌面，对应元素为是否存在，0：没有  1：有
        //相当于一个记牌器
        int[] deskCard = new int[10];

        //使用死循环模拟两个玩家出牌，直到有一方手牌出完则循环结束，游戏结束
        while (true) {
            //--- 玩家p1开始出牌 ---//
            showCard(p1, desk, deskCard);
            if (p1.head == p1.tail) {
                System.out.println(p2.name + "胜利");
                showMsg(p2, desk);
                return;
            }
            //--- 玩家p2开始出牌 ---//
            showCard(p2, desk, deskCard);
            if (p2.head == p2.tail) {
                System.out.println(p1.name + "胜利");
                showMsg(p1, desk);
                return;
            }
        }

    }

    /**
     *
     * @param p 玩家实例
     * @param desk  桌面实例
     * @param deskCard  记牌器
     */
    public static void showCard(Queue p, Stack desk, int[] deskCard) {
        System.out.print(p.name + " 手牌： ");
        for (int i = p.head; i < p.tail; i++) {
            System.out.print(p.data[i] + " ");
        }
        System.out.println();

        //出牌玩家从手牌中最上面拿出一张牌
        int mark = p.data[p.head];
        System.out.println(p.name + " 出牌： " + mark);

        //--- 桌面中存在玩家拿出的牌 ---//
        if (deskCard[mark] == 1) {
            //把刚拿出来的牌放到手牌的最后面
            p.data[p.tail] = mark;
            p.head++;
            p.tail++;
            //从桌面最后一张牌开始收，一直到桌面最上面的牌牌面等于打出的牌
            while (desk.data[desk.top] != mark) {
                deskCard[desk.data[desk.top]] = 0;
                p.data[p.tail] = desk.data[desk.top];
                p.tail++;
                desk.top--;
            }
            //设置打出的牌面在桌上为空
            deskCard[mark] = 0;
            //将和打出的牌牌面相等的牌收回
            p.data[p.tail] = desk.data[desk.top];
            p.tail++;
            desk.top--;
            System.out.println(p.name + " 赢牌了");
        } else {
            //--- 桌面不存在玩家拿出的牌 ---//
            deskCard[mark] = 1;
            p.head++;
            //将拿出的牌放到桌面的最后面
            desk.top++;
            desk.data[desk.top] = mark;
        }
        showMsg(p, desk);
    }


    public static void showMsg(Queue p, Stack desk) {
        System.out.print(p.name + " 手牌： ");
        for (int i = p.head; i < p.tail; i++) {
            System.out.print(p.data[i] + " ");
        }
        System.out.println();
        System.out.println("---------------");
        System.out.print("桌面 余牌： ");
        for (int i = 0; i <= desk.top; i++) {
            if (desk.data[i] == -1) {
                continue;
            }
            System.out.print(desk.data[i] + " ");
        }
        System.out.println();
        System.out.println("===============");
    }

    class Queue {
        int[] data = new int[1000];
        int head;
        int tail;
        //这里设置一个name属性用于区分玩家，可以不要
        String name;
    }

    class Stack {
        int[] data;
        int top;
    }
}
