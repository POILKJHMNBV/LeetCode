package com.example.doublepointer;

/**
 * <p>L925:长按键入</p>
 * @author zhenwu
 * @date 2025/3/8 9:56
 */
public class L925_IsLongPressedName {
    public static void main(String[] args) {
        String name = "alexd", typed = "ale";
        System.out.println(isLongPressedName(name, typed));
    }

    /**
     * 双指针
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(1)
     */
    private static boolean isLongPressedName(String name, String typed) {
        char[] nameChars = name.toCharArray(), typedChars = typed.toCharArray();
        int m = nameChars.length, n = typed.length(), i = 0, j = 0;
        while (i < m && j < n) {
            char ch = nameChars[i];
            int cnt = 0;
            while (i < m && nameChars[i] == ch) {
                i++;
                cnt++;
            }
            while (j < n && typedChars[j] == ch) {
                j++;
                cnt--;
            }
            if (cnt > 0) {
                return false;
            }
        }
        return i >= m && j >= n;
    }
}
