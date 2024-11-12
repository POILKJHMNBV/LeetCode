package com.example.bit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>L260:只出现一次的数字 III</p>
 * <p>
 *     给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按任意顺序返回答案。
 * </p>
 * @author zhenwu
 * @date 2024/11/12 21:19
 */
public class L260_SingleNumber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
        System.out.println(Arrays.toString(singleNumberPro(nums)));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] res = new int[2];
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                res[i++] = entry.getKey();
            }
        }
        return res;
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int[] singleNumberPro(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        // 找到最右边的1
        // 011 ^ 101 = 110
        int rightMostBit = xor & -xor;
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & rightMostBit) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
