package com.example.hash;

import java.util.*;

/**
 * <p>L350:两个数组的交集 II</p>
 * <p>
 *     给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
 *     返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * </p>
 * @author zhenwu
 * @date 2024/12/28 21:52
 */
public class L350_Intersection {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersect(nums1, nums2)));
    }

    /**
     * 哈希表法
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(min(n, m))
     */
    private static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> countMap1 = count(nums1);
        Map<Integer, Integer> countMap2 = count(nums2);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap1.entrySet()) {
            int key = entry.getKey();
            int count = Math.min(entry.getValue(), countMap2.getOrDefault(key, 0));
            for (int i = 0; i < count; i++) {
                list.add(key);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    private static Map<Integer, Integer> count(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    /**
     * 双指针法
     * 时间复杂度：O(nlogn + mlogm)
     * 空间复杂度：O(min(n, m))

     */
    private static int[] intersectPro(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
