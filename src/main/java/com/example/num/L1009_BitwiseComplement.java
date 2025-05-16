package com.example.num;

/**
 * <p>L1009:十进制整数的反码</p>
 * @author zhenwu
 * @date 2025/5/16 22:14
 */
public class L1009_BitwiseComplement {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(0));
    }

    /**
     * 时间复杂度：O(log n)
     * 空间复杂度：O(1)
     */
    private static int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n);
        for (int i = 0, len = s.length(); i < len; i++) {
            n ^= (1 << i);
        }
        return n;
    }
}
