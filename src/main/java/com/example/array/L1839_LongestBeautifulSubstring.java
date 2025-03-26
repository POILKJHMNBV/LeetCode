package com.example.array;

/**
 * <p>L1839:所有元音按顺序排布的最长子字符串</p>
 * @author zhenwu
 * @date 2025/3/26 21:21
 */
public class L1839_LongestBeautifulSubstring {

    public static void main(String[] args) {
        String word = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
        System.out.println(longestBeautifulSubstring(word));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int longestBeautifulSubstring(String word) {
        int maxLen = 0, n = word.length();
        if (n < 5) {
            return maxLen;
        }
        char[] chars = word.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chars[i] != 'a') {
                continue;
            }
            int cnt = 0, j = i;
            boolean skip = false;
            while (j < n) {
                switch (chars[j]) {
                    case 'a':
                        if (cnt == 0) {
                            cnt++;
                        } else if (cnt != 1) {
                            skip = true;
                        }
                        break;
                    case 'e':
                        if (cnt == 1) {
                            cnt++;
                        } else if (cnt != 2) {
                            skip = true;
                        }
                        break;
                    case 'i':
                        if (cnt == 2) {
                            cnt++;
                        } else if (cnt != 3) {
                            skip = true;
                        }
                        break;
                    case 'o':
                        if (cnt == 3) {
                            cnt++;
                        } else if (cnt != 4) {
                            skip = true;
                        }
                        break;
                    case 'u':
                        if (cnt == 4) {
                            cnt++;
                        } else if (cnt != 5) {
                            skip = true;
                        }
                        break;
                }
                if (skip) {
                    break;
                }
                j++;
            }

            if (cnt == 5) {
                maxLen = Math.max(maxLen, j - i);
            }
            i = j - 1;
        }
        return maxLen;
    }
}
