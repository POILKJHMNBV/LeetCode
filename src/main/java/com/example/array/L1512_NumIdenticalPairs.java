package com.example.array;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L1512:好数对的数目</p>
 * @author zhenwu
 * @date 2025/4/24 22:48
 */
public class L1512_NumIdenticalPairs {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 1, 3};
        System.out.println(numIdenticalPairs(nums));
    }

    /**
     * 时间：O(n)
     * 空间：O(n)
     */
    private static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                count += map.get(num);
            }
            map.merge(num, 1, Integer::sum);
        }
        return count;
    }
}
