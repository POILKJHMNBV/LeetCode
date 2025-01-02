package com.example.bit;

/**
 * <p>L693:交替位二进制数</p>
 * <p>给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。</p>
 * @author zhenwu
 * @date 2025/1/2 21:14
 */
public class L693_HasAlternatingBits {
    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(11));
    }

    /**
     * 时间：O(logn)
     * 空间：O(1)
     */
    private static boolean hasAlternatingBits(int n) {
        int pre = -1;
        while (n > 0) {
            int cur = n & 1;
            if (pre != -1 && (pre ^ cur) != 1) {
                return false;
            }
            pre = cur;
            n = (n >> 1);
        }
        return true;
    }
}
