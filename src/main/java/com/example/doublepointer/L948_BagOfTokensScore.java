package com.example.doublepointer;

import java.util.Arrays;

/**
 * <p>L948:令牌放置</p>
 * @author zhenwu
 * @date 2025/2/27 23:07
 */
public class L948_BagOfTokensScore {
    public static void main(String[] args) {

    }

    /**
     * 双指针
     * 时间复杂度：O(n * log n)
     * 空间复杂度：O(1)
     */
    private static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n = tokens.length, l = 0, r = n - 1, score = 0, maxScore = 0;
        while (l <= r) {
            if (tokens[l] <= power) {
                maxScore = Math.max(++score, maxScore);
                power -= tokens[l++];
            } else {
                if (score < 1) {
                    break;
                }
                maxScore = Math.max(score, maxScore);
                score--;
                power += tokens[r--];
            }
        }
        return maxScore;
    }
}
