package com.example.binaryserach;

import java.util.Arrays;

/**
 * <p>L2300:咒语和药水的成功对数</p>
 * @author zhenwu
 * @date 2024/9/16 15:51
 */
public class L2300_SuccessfulPairs {
    public static void main(String[] args) {
        int[] spells = {5, 1, 3}, potions = {1, 2, 3, 4, 5};
        int success = 7;
        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
        System.out.println(Arrays.toString(successfulPairsPro(spells, potions, success)));
    }

    /**
     * 时间：O(m * n)  空间：O(1)
     */
    private static int[] successfulPairs(int[] spells, int[] potions, long success) {
        int len = spells.length;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int count = 0, spell = spells[i];
            for (int potion : potions) {
                if ((long) spell * potion >= success) {
                    count++;
                }
            }
            ans[i] = count;
        }
        return ans;
    }

    /**
     * 时间：O(n * log n)  空间：O(1)
     */
    private static int[] successfulPairsPro(int[] spells, int[] potions, long success) {
        int len = spells.length;
        int[] ans = new int[len];
        Arrays.sort(potions);
        for (int i = 0; i < len; i++) {
            int spell = spells[i];
            int l = 0, r = potions.length;
            while (l < r) {
                int m = l + (r - l) / 2;
                if ((long) spell * potions[m] < success) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            ans[i] = potions.length - l;
        }
        return ans;
    }
}