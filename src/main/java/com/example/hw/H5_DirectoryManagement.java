package com.example.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <p>目录管理</p>
 * <p>实现一个模拟目录管理功能的软件，输入一个命令序列，输出最后一条命令运行结果。 支持命令:
 *      1)创建目录命令: mkdir 目录名称，如mkdir abc为在当前目录创建abc目录，如果已存在同名目录则不执行任何操作。此命令无输出。
 *      2)进入目录命令: cd 目录名称,如cd abc为进入abc目录，特别地，cd ..为返回上级目录，如果目录不存在则不执行任何操作。此命令无输出。
 *      3)查看当前所在路径命令: pwd，输出当前路径字符串
 * 约束: 1)目录名称仅支持小写字母; mkdir和cd命令的参数仅支持单个目录，如: mkdir bc和cd abc; 不支持嵌套路径和绝对路径，如mkdir abc/efg,cd abc/efg,mkdir /abc/efg,cd /abc/efg是不支持的。
 *      2)目录符号为/，根目录/作为初始目录
 * </p>
 * <p>
 *     输入描述：输入N行字符串，每一行字符串是一条命令。
 * </p>
 * <p>
 *     输出描述：输出最后一条命令运行结果字符串
 * </p>
 * @author zhenwu
 * @date 2024/6/29 9:30
 */
public class H5_DirectoryManagement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Directory root = new Directory("");
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] strings = line.split(" ");
            if ("mkdir".equals(strings[0])) {
                root.mkdir(strings[1]);
            } else if ("cd".equals(strings[0])) {
                root = root.cd(strings[1]);
            } else {
                root.pwd();
            }
        }
    }

    private static class Directory {
        final String name;
        final Map<String, Directory> subDirectory;
        Directory parent;

        public Directory(String name) {
            this.name = name;
            this.subDirectory = new HashMap<>();
        }

        public void mkdir(String dirName) {
            if (subDirectory.containsKey(dirName)) {
                return;
            }

            Directory directory = new Directory(dirName);
            directory.parent = this;
            subDirectory.put(dirName, directory);
        }

        public Directory cd(String dirName) {
            if ("..".equals(dirName) && this.parent != null) {
                return this.parent;
            }
            if (subDirectory.containsKey(dirName)) {
                return subDirectory.get(dirName);
            }
            return this;
        }

        public void pwd() {
            Directory temp = this;
            StringBuilder path = new StringBuilder("/");
            while (temp.parent != null) {
                path.insert(0, "/" + temp.name);
                temp = temp.parent;
            }
            System.out.println(path);
        }
    }
}
