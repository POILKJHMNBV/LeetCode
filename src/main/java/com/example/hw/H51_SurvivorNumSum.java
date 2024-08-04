package com.example.hw;

import java.util.*;

/**
 * <p>求幸存数之和</p>
 * <p>
 * 给一个正整数列nums，一个跳数jump，及幸存数量left。
 * 运算过程为:从索引为0的位置开始向后跳，中间跳过 J 个数字，命中索引为 J+1的数字，该数被敲出，并从该点起跳，以此类推，直到幸存left个数为止。然后返回幸存数之和。
 * 约束：
 * 1.0是第一个起跳点。
 * 2.起跳点和命中点之间间隔jump 个数字，已被敲出的数字不计入在内。
 * 3.跳到末尾时无缝从头开始(循环查找)，并可以多次循环。
 * 4.若起始时 left > len(nums) 则无需跳数处理过程。
 * </p>
 * @author zhenwu
 * @date 2024/7/15 20:08
 */
public class H51_SurvivorNumSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int jump = 4;
        int left = 3;
        System.out.println(sumOfLeft(nums, jump, left));
    }

    private static int sumOfLeft(int[] nums, int jump, int left) {
        if (left == 0) {
            return 0;
        }
        if (left >= nums.length) {
            return Arrays.stream(nums).sum();
        }
        List<Integer> list = new LinkedList<>();
        for (int num : nums) {
            list.add(num);
        }

        // 利用removeList保存每轮循环需要被移除的数字的索引
        List<Integer> removeList = new ArrayList<>();
        int index = 0;
        while (list.size() != left) {
            // 每轮循环开始时第一个被移除元素的索引
            index = (index + jump + 1) % (list.size() + removeList.size());
            removeList.clear();
            while (index < list.size()) {
                removeList.add(index);
                if (index + jump + 1 > list.size()) {
                    break;
                }
                index += (jump + 1);
            }

            int size = removeList.size();
            for (int i = size - 1; i >= 0; i--) {
                int removeIndex = removeList.get(i);
                list.remove(removeIndex);
            }
        }
        System.out.println(list);
        return list.stream().reduce(Integer::sum).get();
    }
}
