package com.example.binaryserach;

import java.util.*;

/**
 * L287:寻找重复数
 * <p>
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回这个重复的数。
 * </p>
 */
public class L287_FindDuplicate {
    public static void main(String[] args) {
        System.out.println(findDuplicate1(new int[]{1, 3, 4, 2, 2}));
        System.out.println(findDuplicate2(new int[]{1, 3, 4, 2, 2}));
    }

    private static int findDuplicate1(int[] nums) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>(length - 1);
        for (int num : nums) {
            if (!set.add(num)){
                return num;
            }
        }
        return -1;
    }

    private static int findDuplicate2(int[] nums) {
        int length = nums.length;
        int l = 1;
        int r = length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= m)
                    count++;
            }
            if (count > m) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
