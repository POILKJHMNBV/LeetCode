package com.example.hw;

import com.example.hash.L560_SubarraySum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <p>最长连续子序列</p>
 * <p>
 *     有N个正整数组成的一个序列。给定整数sum，求长度最长的连续子序列，使他们的和等于sum，返回此子序列的长度，
 *     如果没有满足要求的序列，返回-1。
 * </p>
 * <p>
 *     第一行输入是：N个正整数组成的一个序列。
 *     第二行输入是：给定整数 sum。
 * </p>
 * <p>
 *     备注:
 *          输入序列仅由数字和英文逗号构成，数字之间采用英文逗号分隔
 *          序列长度：1 <= N <= 200
 *          输入序列不考虑异常情况
 * </p>
 * @author zhenwu
 * @date 2024/7/7 10:45
 */
public class H22_MaxContinuousSubString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int sum = in.nextInt();
        System.out.println(maxLength(nums, sum));
        System.out.println(maxLengthPro(nums, sum));
    }

    /**
     * 暴力求解
     */
    private static int maxLength(int[] nums, int sum) {
        int result = -1;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int total = 0, j = i;
            for (;j < length; j++) {
                total += nums[j];
                if (total == sum) {
                    result = Math.max(result, j - i + 1);
                } else if (total > sum) {
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 前缀和+哈希表
     * @see L560_SubarraySum
     */
    private static int maxLengthPro(int[] nums, int sum) {
        // key-前缀和  value-前缀和的索引
        Map<Integer, Integer> map = new HashMap<>();

        // 初始化map
        map.put(0, -1);

        int pre = 0, result = -1;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - sum)) {
                int beginIndex = map.get(pre - sum);
                result = Math.max(result, i - beginIndex);
            }
            map.put(pre, i);
        }

        return result;
    }
}
