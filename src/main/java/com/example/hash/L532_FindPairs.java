package com.example.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L532:数组中的 k-diff 数对</p>
 * @author zhenwu
 * @date 2024/12/10 21:20
 */
public class L532_FindPairs {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 4, 3, 3, 0, 9, 2, 3};
        int k = 3;
        System.out.println(findPairs(nums, k));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int num : nums) {
            if (k == 0) {
                if (map.containsKey(num) && map.remove(num) > 1) {
                    count++;
                }
            } else {
                if(!map.containsKey(num)){
                    continue;
                }
                int a = num - k, b = num + k;
                if (map.containsKey(a)) {
                    count++;
                }
                if (map.containsKey(b)) {
                    count++;
                }
                map.remove(num);
            }
        }
        return count;
    }
}
