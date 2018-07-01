package com.brianway.learning.java.io;


import java.io.File;

/**
 * File的常用操作
 */
public class FileUtil {
    public static void main(String[] args) {
        System.out.println("hello word");
    }

    /**
     * 删除一个文件夹或者文件列表
     *
     * @param file
     */
    public static void deleteFile(File file) {
        if (file == null) {
            return;
        } else if (file.isFile()) {
            file.delete();
        } else if (file.isDirectory()) {
            String[] str = file.list();
            if (str == null) {
                file.delete();
            } else {
                for (String str1 : str) {
                    deleteFile(new File(file, str1));
                }
                file.delete();
            }
        }
    }

}
