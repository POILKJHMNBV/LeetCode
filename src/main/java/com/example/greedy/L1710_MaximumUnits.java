package com.example.greedy;

import java.util.Arrays;

/**
 * <p>L1710:卡车上的最大单元数</p>
 * @author zhenwu
 * @date 2025/9/19 22:03
 */
public class L1710_MaximumUnits {
    public static void main(String[] args) {

    }

    /**
     * 贪心算法
     * 时间复杂度：O(n log n)
     * 空间复杂度：O(n)
     */
    private static int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
        int ans = 0;
        for (int[] boxType : boxTypes) {
            int num = boxType[0], units = boxType[1];
            if (num < truckSize) {
                ans += num * units;
                truckSize -= num;
            } else {
                ans += truckSize * units;
                break;
            }
        }
        return ans;
    }
}
