package com.example.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>L217:存在重复元素</p>
 * @author zhenwu
 * @date 2024/11/1 21:39
 */
public class L217_ContainsDuplicate {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }
}
