package com.example.bit;

/**
 * <p>L1476:数组异或操作</p>
 * @author zhenwu
 * @date 2025/6/26 22:04
 */
public class L1486_XorOperation {
    public static void main(String[] args) {
        int n = 5;
        int start = 0;
        System.out.println(xorOperation(n, start));
    }

    /**
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            res ^= start + 2 * i;
        }
        return res;
    }
}
