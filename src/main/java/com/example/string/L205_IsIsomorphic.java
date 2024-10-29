package com.example.string;

/**
 * <p>L205:同构字符串</p>
 * @author zhenwu
 * @date 2024/10/29 21:33
 */
public class L205_IsIsomorphic {
    public static void main(String[] args) {
        String s = "badc";
        String t = "baba";
        System.out.println(isIsomorphic(s, t));
    }

    /**
     * 判断两个字符串是否是同构字符串
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] mapS = new int[256];
        int[] mapT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (mapS[a] == 0 && mapT[b] == 0) {
                mapS[a] = b;
                mapT[b] = a;
            } else if (mapS[a] != 0 && mapS[a] != b || mapT[b] != 0 && mapT[b] != a) {
                return false;
            }
        }
        return true;
    }
}