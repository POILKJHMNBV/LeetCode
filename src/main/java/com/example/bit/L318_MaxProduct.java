package com.example.bit;

/**
 * <p>L318:最大单词长度乘积</p>
 * @author zhenwu
 * @date 2024/11/21 22:00
 */
public class L318_MaxProduct {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n^2)，其中 n 是单词数组的长度
     * 空间复杂度：O(n)
     */
    private static int maxProductPro(String[] words) {
        int n = words.length, index = 0;
        // 利用位运算，将每个单词中出现的字母的二进制位设置为 1
        int[] mask = new int[n];
        for (String word : words) {
            int t = 0;
            for (char ch : word.toCharArray()) {
                t |= 1 << (ch - 'a');
            }
            mask[index++] = t;
        }

        int maxProduct = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }
        return maxProduct;
    }

    /**
     * 时间复杂度：O(n^2 * C)，其中 n 是单词数组的长度，C 是字符集的大小。
     * 空间复杂度：O(1)
     * 超时
     */
    private static int maxProduct(String[] words) {
        int len = words.length;
        int maxProduct = 0;
        for (String word : words) {
            for (int j = 1; j < len; j++) {
                if (hasPublicChar(word, words[j])) {
                    continue;
                }
                maxProduct = Math.max(maxProduct, word.length() * words[j].length());
            }
        }
        return maxProduct;
    }

    private static boolean hasPublicChar(String word1, String word2) {
        for (char c : word1.toCharArray()) {
            if (word2.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}
