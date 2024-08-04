package com.example.recursion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>L491:递增子序列</p>
 * <p>给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。</p>
 */
public class L491_FindSubsequences {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("./file/demo.txt"));
        String output = br.readLine();
        String expect = br.readLine();
        br.close();
        String s1 = output.substring(2, output.length() - 2).replace("],[", "|+|");
        String s2 = expect.substring(2, expect.length() - 2).replace("],[", "|+|");
        System.out.println(s1.split("[|][+][|]").length);
        System.out.println(s2.split("[|][+][|]").length);

        List<String> outputList = new ArrayList<>(Arrays.asList(s1.split("[|][+][|]")));
        List<String> expectList = new ArrayList<>(Arrays.asList(s2.split("[|][+][|]")));

        List<String> list = outputList.stream()
                .collect(Collectors.groupingBy(v -> v, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(list);

        System.out.println(outputList.size());
        System.out.println(expectList.size());

        expectList.removeAll(outputList);
        System.out.println(expectList);

        int[] nums = {1, 1, 1, 1, 1, 1, 1};
        System.out.println(findSubsequences(nums));
    }

    private static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int[] used = new int[nums.length];
        process(res, nums, used, new ArrayList<>(), 0);
        return res;
    }

    private static void process(List<List<Integer>> res, int[] nums, int[] used, List<Integer> path, int startIndex) {
        int size = path.size();
        if (size >= 2) {
            if (path.get(size - 1) >= path.get(size - 2)) {
                res.add(new ArrayList<>(path));
            } else {
                return;
            }
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            path.add(nums[i]);
            if (path.size() == 1 && i > 0 && nums[i] < nums[i - 1]) {
                return;
            }
            used[i] = 1;
            process(res, nums, used, path, i + 1);
            used[i] = 0;
            path.remove(path.size() - 1);
        }
    }
}