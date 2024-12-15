package com.example.array;

/**
 * <p>L335:路径交叉</p>
 * @author zhenwu
 * @date 2024/12/15 20:54
 */
public class L335_IsSelfCrossing {
    public static void main(String[] args) {
        int[] d = {2, 1, 1, 2};
        System.out.println(isSelfCrossing(d));
    }

    /**
     * 判断路径是否交叉
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        if (n < 4) return false;
        for (int i = 3; i < n; i++) {
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) return true;
            if (i >= 4 && distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2]) return true;
            if (i >= 5 && distance[i - 1] <= distance[i - 3] && distance[i - 2] > distance[i - 4] && distance[i] + distance[i - 4] >= distance[i - 2] && distance[i - 1] + distance[i - 5] >= distance[i - 3]) return true;
        }
        return false;
    }
}
