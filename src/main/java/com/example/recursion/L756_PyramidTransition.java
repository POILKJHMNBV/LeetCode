package com.example.recursion;

import java.util.*;

/**
 * <p>L756:金字塔转换矩阵</p>
 * @author zhenwu
 * @date 2025/1/1 10:05
 */
public class L756_PyramidTransition {
    public static void main(String[] args) {
        String bottom = "AAAA";
        List<String> allowed = new ArrayList<>(Arrays.asList("AAB","AAC","BCD","BBE","DEF"));
        System.out.println(pyramidTransition(bottom, allowed));
    }

    private static boolean dfsT(String bottom, String above, Map<String, List<String>> pyramid) {
        if (bottom.length() == 2 && above.length() == 1) {
            return true;
        }

        // 上一层构建完毕，递归构建下一层
        if (bottom.length() == above.length() + 1) {
            return dfsT(above, "", pyramid);
        }

        String base = bottom.substring(above.length(), above.length() + 2);
        if (pyramid.containsKey(base)) {
            for (String value : pyramid.get(base)) {
                if (dfsT(bottom, above + value, pyramid)) {
                    return true;
                }
            }
        }

        return false;
    }


    private static boolean pyramidTransition(String bottom, List<String> allowed) {
        // 构建转换规则map
        Map<String, List<String>> pyramid = new HashMap<>();
        for (String v : allowed) {
            String key = v.substring(0, 2);
            String value = v.substring(2);
            pyramid.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        }

        return dfsT(bottom, "", pyramid);
    }
}
