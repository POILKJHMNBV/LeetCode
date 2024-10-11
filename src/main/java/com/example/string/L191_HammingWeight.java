package com.example.string;

/**
 * <p>L191:位1的个数</p>
 * @author zhenwu
 * @date 2024/10/11 21:49
 */
public class L191_HammingWeight {
    public static void main(String[] args) {

    }

    /**
     * 时间：O(1)   空间：O(1)
     */
    private static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
}
