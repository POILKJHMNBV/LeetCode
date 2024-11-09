package com.example.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L228:汇总区间</p>
 * @author zhenwu
 * @date 2024/11/9 21:13
 */
public class L228_SummaryRanges {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
        List<String> res = summaryRanges(nums);
        for (String s : res) {
            System.out.println(s);
        }
    }

    /**
     * 汇总区间
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        res.add(nums[0] + "");
        int start = 0, i = 1;
        for (; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] + 1) {
                if (i - start > 1) {
                    res.set(res.size() - 1, res.get(res.size() - 1) + "->" + nums[i - 1]);
                }
                res.add(nums[i] + "");
                start = i;
            }
        }
        if (i - start > 1) {
            res.set(res.size() - 1, res.get(res.size() - 1) + "->" + nums[i - 1]);
        }
        return res;
    }
}
