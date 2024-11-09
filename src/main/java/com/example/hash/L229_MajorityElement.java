package com.example.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>L229:多数元素 II</p>
 * @author zhenwu
 * @date 2024/11/9 21:26
 */
public class L229_MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3};
        List<Integer> res = majorityElement(nums);
        for (Integer i : res) {
            System.out.println(i);
        }
    }

    /**
     * 哈希表法
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        int count = len / 3;
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int num : nums) {
            counterMap.put(num, counterMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
            if (entry.getValue() > count) {
                res.add(entry.getKey());

            }
        }
        return res;
    }
}
