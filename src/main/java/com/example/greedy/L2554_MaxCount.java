package com.example.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>L2554:从一个范围内选择最多整数 I</p>
 * @author zhenwu
 * @date 2025/9/21 15:11
 */
public class L2554_MaxCount {
    public static void main(String[] args) {
        int[] banned = {176, 36, 104, 125, 188, 152, 101, 47, 51, 65, 39, 174, 29, 55, 13, 138, 79,
                81, 175, 178, 42, 108, 24, 80, 183, 190, 123, 20, 139, 22, 140, 62, 58, 137, 68, 148, 172,
                76, 173, 189, 151, 186, 153, 57, 142, 105, 133, 114, 165, 118, 56, 59, 124, 82, 49, 94, 8,
                146, 109, 14, 85, 44, 60, 181, 95, 23, 150, 97, 28, 182, 157, 46, 160, 155, 12, 67, 135,
                117, 2, 25, 74, 91, 71, 98, 127, 120, 130, 107, 168, 18, 69, 110, 61, 147, 145, 38};
        int n = 3016;
        int maxSum = 240;
        System.out.println(maxCount(banned, n, maxSum));
    }

    /**
     * 贪心算法
     * 时间复杂度：O(n + m), 其中 n 是 banned 数组的长度
     * 空间复杂度：O(m)
     */
    private static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int i : banned) {
            set.add(i);
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }
            if (maxSum - i >= 0) {
                cnt++;
                maxSum -= i;
            }
        }
        return cnt;
    }
}
