package com.example.array;

/**
 * <p>L1578:使绳子变成彩色的最短时间</p>
 * @author zhenwu
 * @date 2025/3/25 21:47
 */
public class L1578_MinCost {

    public static void main(String[] args) {
        String colors = "abaac";
        int[] neededTime = {1, 2, 3, 4, 5};
        System.out.println(minCost(colors, neededTime));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int minCost(String colors, int[] neededTime) {
        char[] chars = colors.toCharArray();
        int ans = 0;
        for (int i = 0, n = chars.length; i < n; i++) {
            char ch = chars[i];
            int maxTime = neededTime[i], totalTime = 0, j = i;
            while (j < n && ch == chars[j]) {
                totalTime += neededTime[j];
                maxTime = Math.max(maxTime, neededTime[j++]);
            }
            if (j - i > 1) {
                ans += totalTime - maxTime;
            }
            i = j - 1;
        }
        return ans;
    }
}
