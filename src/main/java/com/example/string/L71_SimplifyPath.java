package com.example.string;

import java.util.LinkedList;

/**
 * <p>L71:简化路径</p>
 * @author zhenwu
 * @date 2024/10/5 21:07
 */
public class L71_SimplifyPath {
    public static void main(String[] args) {
        String path = "/.../a/../b/c/../d/./";
        System.out.println(simplifyPath(path));
    }

    /**
     * 时间：O(n)  空间：O(n)
     */
    private static String simplifyPath(String path) {
        LinkedList<String> list = new LinkedList<>();
        String[] strings = path.split("/");
        for (String s : strings) {
            if ("..".equals(s)) {
                list.pollLast();
            } else if (!(".".equals(s) || "".equals(s))) {
                list.offer(s);
            }
        }
        return "/" + String.join("/", list);
    }
}
