package part_01.冒泡排序;

import java.util.Scanner;

/**
 * 使用冒泡排序对学生姓名-学生成绩排序
 */
public class Main02 {
    public static void main(String[] args) {
        //定义一个内部类模仿c语言结构体
        class Student {
            String name;
            Integer scorce;
        }

        Student[] arr = new Student[10];

        int n = 0;
        while (true) {
            if (n >= 10) {
                break;
            }
            System.out.println("请输入学生姓名：");
            String name = new Scanner(System.in).nextLine();
            System.out.println("请输入学生成绩：");
            Integer score;
            try {
                score = new Integer(new Scanner(System.in).nextLine());
            } catch (NumberFormatException e) {
                System.out.println("请输入数字");
                continue;
            }
            Student student = new Student();
            student.name = name;
            student.scorce = score;
            arr[n] = student;
            n++;
        }

        System.out.printf("排序前：\n");
        for (Student s : arr) {
            System.out.printf("姓名：%s \t- 成绩：%d \n", s.name, s.scorce);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].scorce > arr[j + 1].scorce) {
                    int t = arr[j].scorce;
                    arr[j].scorce = arr[j + 1].scorce;
                    arr[j + 1].scorce = t;
                }
            }
        }
        System.out.printf("排序后：\n");
        for (Student s : arr) {
            System.out.printf("姓名：%s\t - 成绩：%d \n", s.name, s.scorce);
        }
    }
}
