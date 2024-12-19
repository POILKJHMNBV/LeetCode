package com.example.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L401:二进制手表</p>
 * @author zhenwu
 * @date 2024/12/19 22:09
 */
public class L401_ReadBinaryWatch {
    public static void main(String[] args) {
        int turnedOn = 1;
        System.out.println(readBinaryWatchDfs(turnedOn));
    }

    /**
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     */
    private static List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    res.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        return res;
    }

    /**
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     */
    private static List<String> readBinaryWatchDfs(int turnedOn) {
        int[] hours = {8, 4, 2, 1};
        int[] minutes = {32, 16, 8, 4, 2, 1};
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 6; j++) {
                if (i + j == turnedOn) {
                    List<Integer> hoursList = dfs(hours, i);
                    List<Integer> minutesList = dfs(minutes, j);
                    for (int hour : hoursList) {
                        for (int minute : minutesList) {
                            if (hour < 12 && minute < 60) {
                                res.add(hour + ":" + (minute < 10 ? "0" : "") + minute);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private static List<Integer> dfs(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        dfs(nums, 0, k, 0, res);
        return res;
    }

    private static void dfs(int[] nums, int startIndex,
                            int k, int sum,
                            List<Integer> res) {
        if (k == 0) {
            res.add(sum);
            return;
        }
        for (int i = startIndex; i < nums.length; ++i) {
            dfs(nums, i + 1, k - 1, sum + nums[i], res);
        }
    }
}
