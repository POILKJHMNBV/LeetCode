package com.example.array;

/**
 * <p>L1010:总持续时间可被 60 整除的歌曲</p>
 * @author zhenwu
 * @date 2025/5/1 15:07
 */
public class L1010_NumPairsDivisibleBy60 {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        int[] cnt = new int[60];
        for (int num : time) {
            ans += cnt[(60 - num % 60) % 60];
            cnt[num % 60]++;
        }
        return ans;
    }
}
