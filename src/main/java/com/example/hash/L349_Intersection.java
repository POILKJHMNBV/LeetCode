package com.example.hash;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>L349:两个数组的交集</p>
 * <p>
 *     给定两个数组 nums1 和 nums2 ，返回它们的交集。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * </p>
 * @author zhenwu
 * @date 2024/8/15 21:03
 */
public class L349_Intersection {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        int[] intersection = intersection(nums1, nums2);
    }

    private static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).distinct().boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).distinct().boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        int[] res = new int[set1.size()];
        int i = 0;
        for (int num : set1) {
            res[i++] = num;
        }
        return res;
    }
}
