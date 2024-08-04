package com.example.greedy;

import java.util.Arrays;

/**
 * <p>L455:分发饼干</p>
 * <p>假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j]。
 * 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。</p>
 */
public class L455_FindContentChildren {
    public static void main(String[] args) {
        int[] g = {1, 2, 3}, s = {1, 1};
        System.out.println(findContentChildren(g, s));
    }

    /**
     * @param g 每一个孩子的胃口值
     * @param s 每一个饼干的尺寸
     * @return 满足最多孩子的数量
     */
    private static int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) {
            return 0;
        }
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int maxNum = 0;
        int p1 = 0, p2 = 0;
        while (p1 < g.length && p2 < s.length) {
            if (g[p1] <= s[p2]) {
                p1++;
                maxNum++;
            }
            p2++;
        }
        return maxNum;
    }
}
