package demo._0101;

import java.io.File;
import java.util.Scanner;

public class RenameFile {
    static String srcPath;

    public static void main(String[] args) {
        System.out.println("请输入文件夹路径:");
        srcPath = input();
        moveFile(srcPath);
//        renameFile(input);
    }

    /**
     * 将文件移动到输入的目录
     */
    public static void moveFile(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                moveFile(f.getAbsolutePath());
            } else {
                f.renameTo(new File(srcPath + "/" + f.getName()));
            }
        }
    }

    /**
     * 将文件重命名在原路径（01.aaa.mp3删除‘01.’）
     *
     * @param path
     */
    public static void renameFile(String path) {
        File[] files = new File(path).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                renameFile(file.getAbsolutePath());
            } else {
                String name = file.getName();
                System.out.printf("原文件名: %s \n", name);
                int indexOf = name.indexOf('.') + 1;
                String finalName = name.substring(indexOf);
                file.renameTo(new File(path + "/" + finalName));
            }
        }
    }

    public static String input() {
        return new Scanner(System.in).nextLine();
    }
}
