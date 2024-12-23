package com.example.recursion;

import java.util.Arrays;

/**
 * <p>L1079:活字印刷</p>
 * @author zhenwu
 * @date 2024/12/22 20:08
 */
public class L1079_NumTilePossibilities {
    public static void main(String[] args) {
        String tiles = "CDC";
        System.out.println(numTilePossibilities(tiles));
    }

    /**
     * 时间：O(n * n!)
     * 空间：O(n)
     */
    private static int numTilePossibilities(String tiles) {
        char[] charArray = tiles.toCharArray();
        int n = charArray.length;
        Arrays.sort(charArray);
        dfs(charArray, new boolean[n], new boolean[n]);
        return count;
    }

    private static int count = 0;

    private static void dfs(char[] charArray,
                            boolean[] depthUsed,
                            boolean[] levelUsed) {
        for (int i = 0; i < charArray.length; i++) {
            if (i > 0 && charArray[i] == charArray[i - 1] && !levelUsed[i - 1]) {
                continue;
            }
            if (depthUsed[i]) {
                continue;
            }
            levelUsed[i] = true;
            depthUsed[i] = true;
            count++;
            dfs(charArray, depthUsed, levelUsed);
            depthUsed[i] = false;
            levelUsed[i] = false;
        }
    }
}
