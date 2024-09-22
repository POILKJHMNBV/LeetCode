package com.example.array;

/**
 * <p>L1318:或运算的最小翻转次数</p>
 * @author zhenwu
 * @date 2024/9/22 10:28
 */
public class L1318_MinFlips {
    public static void main(String[] args) {
        int a = 2, b = 6, c = 5;
        System.out.println(minFlips(a, b, c));
    }

    /**
     * 时间复杂度：O(logC)  空间复杂度：O(1)
     * O(logC) 等价于 C 的位数
     */
    private static int minFlips(int a, int b, int c) {
        int ans = 0, mask = 1;
        for (int i = 0; i < 32; i++) {
            int bitA = a & mask;
            int bitB = b & mask;
            int bitC = c & mask;

            if (bitC == 0) {
                if (bitA > 0) {
                    ans++;
                }
                if (bitB > 0) {
                    ans++;
                }
            } else {
                if (bitA == 0 && bitB == 0) {
                    ans++;
                }
            }

            mask <<= 1;
        }
        return ans;
    }
}
