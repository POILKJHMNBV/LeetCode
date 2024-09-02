package com.example.hash;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>L2215:找出两数组的不同</p>
 * @author zhenwu
 * @date 2024/9/2 20:43
 */
public class L2215_FindDifference {
    public static void main(String[] args) {

    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        Set<Integer> set1Bak = new HashSet<>(set1);
        set1.removeAll(set2);
        set2.removeAll(set1Bak);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(set1));
        res.add(new ArrayList<>(set2));
        return res;
    }
}
