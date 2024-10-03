package com.example.string;

/**
 * <p>L65:有效数字</p>
 * @author zhenwu
 * @date 2024/10/3 9:16
 */
public class L65_IsNumber {
    public static void main(String[] args) {
        String s = "+6e-1";
        System.out.println(isNumber(s));
    }

    /**
     * 时间：O(n)     空间：O(n)
     */
    private static boolean isNumber(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        int n = s.length();
        char[] cs = s.toCharArray();
        int idx = -1;
        for (int i = 0; i < n; i++) {
            // e 或 E 只能出现一次
            if (cs[i] == 'e' || cs[i] == 'E') {
                if (idx != -1) {
                    return false;
                }
                idx = i;
            }
        }

        if (idx != -1) {
            // 'e' 或 'E' 的左边必须是浮点数或整数，右边必须是整数
            return check(cs, 0, idx - 1, false) && check(cs, idx + 1, n - 1, true);
        } else {
            // 没有 'e' 或 'E'，整个字符串必须是浮点数或整数
            return check(cs, 0, n - 1, false);
        }
    }

    /**
     * 检查字符串是否是整数或浮点数
     * @param cs          字符数组
     * @param start       起始位置
     * @param end         结束位置
     * @param mustInteger 是否必须是整数
     * @return 字符串是否是整数或浮点数
     */
    private static boolean check(char[] cs, int start, int end, boolean mustInteger) {
        if (start > end) {
            return false;
        }
        if (cs[start] == '+' || cs[start] == '-') {
            start++;
        }
        boolean hasDot = false, hasNum = false;
        for (int i = start; i <= end; i++) {
            if (cs[i] == '.') {
                // 整数不能有小数点，浮点数不能有两个点
                if (mustInteger || hasDot) {
                    return false;
                }
                hasDot = true;
            } else if (cs[i] >= '0' && cs[i] <= '9') {
                // 字符串中有数字
                hasNum = true;
            } else {
                // 字符串中有非数字字符
                return false;
            }
        }
        return hasNum;
    }
}
