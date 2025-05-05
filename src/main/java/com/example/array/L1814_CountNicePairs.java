package com.example.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L1814:统计一个数组中好对子的数目</p>
 * @author zhenwu
 * @date 2025/5/5 10:45
 */
public class L1814_CountNicePairs {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int countNicePairs(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        long cnt = 0;
        for (int num : nums) {
            int key = num - reverseNum(num);
            cnt += cntMap.getOrDefault(key, 0);
            cntMap.merge(key, 1, Integer::sum);
        }
        return (int) (cnt % 1000000007);
    }

    private static int reverseNum(int num) {
        int ans = 0;
        while (num != 0) {
            int a = num % 10;
            ans = ans * 10 + a;
            num /= 10;
        }
        return ans;
    }
}
