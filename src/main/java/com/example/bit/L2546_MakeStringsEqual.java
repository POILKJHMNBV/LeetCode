package com.example.bit;

/**
 * <p>L2546:执行逐位运算使字符串相等</p>
 * @author zhenwu
 * @date 2025/7/19 21:52
 */
public class L2546_MakeStringsEqual {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static boolean makeStringsEqual(String s, String target) {
        return s.contains("1") == target.contains("1");
    }
}
