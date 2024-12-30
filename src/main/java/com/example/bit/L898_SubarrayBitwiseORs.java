package com.example.bit;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>L898:子数组按位或操作</p>
 * <p>给定一个整数数组 arr，返回所有 arr 的非空子数组的不同按位或的数量。</p>
 * @author zhenwu
 * @date 2024/12/30 21:35
 */
public class L898_SubarrayBitwiseORs {
    public static void main(String[] args) {
        int[] arr = {108, 121, 9, 85, 27};
        System.out.println(subarrayBitwiseORs(arr));
    }

    /**
     * 暴力解法，超时
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     */
    private static int subarrayBitwiseORs(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
            int tmp = arr[i];
            for (int j = i + 1; j < n; j++) {
                tmp |= arr[j];
                set.add(tmp);
            }
        }
        return set.size();
    }

    /**
     * 优化解法
     * 时间复杂度：O(n * 30)
     * 空间复杂度：O(n * 30)
     */
    private static int subarrayBitwiseORsPro(int[] arr) {
        Set<Integer> result = new HashSet<>();
        // 维护当前元素结尾的所有子数组的按位或结果集合
        Set<Integer> current = new HashSet<>();

        for (int num : arr) {
            Set<Integer> temp = new HashSet<>();
            for (int val : current) {
                temp.add(val | num);
            }
            temp.add(num);
            current = temp;
            result.addAll(current);
        }

        return result.size();
    }
}
