package com.example.doublepointer;

/**
 * <P>L392:判断子序列</P>
 * @author zhenwu
 * @date 2024/8/31 15:39
 */
public class L392_IsSubsequence {
    public static void main(String[] args) {
        String  s = "axc", t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
        System.out.println(isSubsequencePro(s, t));
    }

    private static boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        if (t.contains(s)) {
            return true;
        }
        int index = -1;
        for (char ch : s.toCharArray()) {
            if ((index = t.indexOf(ch, index + 1)) == -1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSubsequencePro(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                if (i == s.length())  {
                    return true;
                }
            }
            j++;
        }
        return false;
    }
}
