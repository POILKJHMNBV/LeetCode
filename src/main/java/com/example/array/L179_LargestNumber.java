package com.example.array;

import java.util.Arrays;

/**
 * <p>L179:最大数</p>
 * @author zhenwu
 * @date 2024/10/27 20:57
 */
public class L179_LargestNumber {
    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
        System.out.println("330".compareTo("303"));
        System.out.println("3430".compareTo("3034"));
    }

    /**
     * 时间复杂度：O(n * logn)
     * 空间复杂度：O(n)
     */
    private static String largestNumber(int[] nums) {
        String[] asStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            asStrs[i] = String.valueOf(nums[i]);
        }

        // 自定义排序规则
        Arrays.sort(asStrs, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1); // 降序排列
        });

        // 如果最大的数是0，那么直接返回0
        if (asStrs[0].equals("0")) {
            return "0";
        }

        // 拼接字符串
        StringBuilder sb = new StringBuilder();
        for (String s : asStrs) {
            sb.append(s);
        }

        return sb.toString();
    }
}
