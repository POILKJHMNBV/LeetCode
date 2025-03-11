package com.example.doublepointer;

/**
 * <p>L2486:追加字符以获得子序列</p>
 * @author zhenwu
 * @date 2025/3/11 21:29
 */
public class L2486_AppendCharacters {
    public static void main(String[] args) {

    }

    /**
     * 双指针
     * 时间复杂度：O(min(m, n))
     * 空间复杂度：O(1)
     */
    private static int appendCharacters(String s, String t) {
        int m = s.length(), n = t.length(), i = 0, j = 0;
        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                ++j;
            }
            ++i;
        }
        return n - j;
    }
}
