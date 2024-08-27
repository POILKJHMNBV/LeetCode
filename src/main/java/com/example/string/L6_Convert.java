package com.example.string;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L6:Z 字形变换</p>
 * @author zhenwu
 * @date 2024/8/27 20:49
 */
public class L6_Convert {
    public static void main(String[] args) {

    }

    private static String convert(String s, int numRows) {
        if (numRows < 2) {
            return s;
        }

        // 利用数组下标模拟Z字形变换
        List<StringBuilder> rows = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0, flag = -1;
        for (char ch : s.toCharArray()) {
            rows.get(i).append(ch);
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }
            i += flag;
        }

        return rows.stream().reduce(StringBuilder::append).get().toString();
    }
}
