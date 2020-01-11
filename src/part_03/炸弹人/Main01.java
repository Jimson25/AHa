package part_03.炸弹人;

import java.util.Random;

/**
 * 炸弹人游戏
 * 需求:
 * 在炸弹人游戏中有一枚炸弹,可以炸光横竖方向的所有气球,
 * 在随机生成的地图上计算出炸弹放在哪里可以消灭最多的敌人
 * 分析:
 * 生成地图:
 * 使用一个二维数组表示地图,使用'#'、'G'、'-'分别代表墙、气球、空地
 * 设置地图边框为墙
 * 算法实现:
 * 从第一个点开始遍历整个地图，计算是否可以安放炸弹，
 * 不可以：
 * 继续遍历下一个点
 * 可以：
 * 分别计算x方向往左、x方向往右、y方向往上、y方向往下存在的气球数量，
 * 每存在一个气球则count+1，碰到墙截止，将XY、count保存起来
 * 循环结束后统计最大的count对应的XY
 *
 * -----------------------------------
 * 完成后照着输出数了下数字是对的，其他位置懒得数了
 */
public class Main01 {
    public static void main(String[] args) {
        char[][] chars = create(20, 20);
        getLocation(chars);
    }


    public static void getLocation(char[][] arr) {
        int max = 0;
        int X = 0, Y = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != '-') {
                    continue;
                }
                int count = 0;
                //x右边
                for (int x = i; arr[x][j] != '#'; x++) {
                    if (arr[x][j] == 'G') {
                        count++;
                    }
                }
                //x左边
                for (int x = i; arr[x][j] != '#'; x--) {
                    if (arr[x][j] == 'G') {
                        count++;
                    }
                }
                //y往上
                for (int y = j; arr[i][y] != '#'; y++) {
                    if (arr[i][y] == 'G') {
                        count++;
                    }
                }
                //y往下
                for (int y = j; arr[i][y] != '#'; y--) {
                    if (arr[i][y] == 'G') {
                        count++;
                    }
                }
                if (count > max) {
                    max = count;
                    X = i;
                    Y = j;
                }

            }
        }
        System.out.println("在X =" + X + " ,Y = " + Y + "的位置消灭的敌人最多，总数为：" + max);
    }

    /**
     * 创建一个炸弹人的地图
     *
     * @param x 行数
     * @param y 列数
     * @return
     */
    public static char[][] create(int x, int y) {
        char[][] arr = new char[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 || j == 0 || i == x - 1 || j == y - 1) {
                    arr[i][j] = '#';
                    continue;
                }
                switch (new Random().nextInt(5)) {
                    case 0:
                        arr[i][j] = '#';
                        break;
                    case 1:
                    case 2:
                        arr[i][j] = 'G';
                        break;
                    default:
                        arr[i][j] = '-';
                        break;
                }
            }
        }

        for (char[] a : arr) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + "\t");
            }
            System.out.println();
        }

        return arr;
    }

}
