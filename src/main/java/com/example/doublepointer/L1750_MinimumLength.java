package com.example.doublepointer;

/**
 * <p>L1750:删除字符串两端相同字符后的最短长度</p>
 * @author zhenwu
 * @date 2025/2/25 21:19
 */
public class L1750_MinimumLength {
    public static void main(String[] args) {
        System.out.println(minimumLength("ca"));
        System.out.println(minimumLength("cabaabac"));
        System.out.println(minimumLength("aabccabba"));
    }

    /**
     * 双指针
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int minimumLength(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            char lc = chars[l], rc = chars[r];
            if (lc != rc) {
                break;
            }
            while (l < r && chars[l] == lc) {
                l++;
            }
            while (r >= l && chars[r] == rc) {
                r--;
            }
        }
        return r - l + 1;
    }
}
