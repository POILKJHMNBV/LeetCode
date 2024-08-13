package com.example.doublepointer;

/**
 * <p>L844:比较含退格的字符串</p>
 * <p>
 *     给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 *     注意：如果对空文本输入退格字符，文本继续为空。
 * </p>
 * @author zhenwu
 * @date 2024/8/13 20:26
 */
public class L844_BackspaceCompare {
    public static void main(String[] args) {
        String s = "ab#c", t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }

    private static boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skipS = 0, skipT = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    i--;
                    skipS++;
                } else if (skipS > 0) {
                    i--;
                    skipS--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    j--;
                    skipT++;
                } else if (skipT > 0) {
                    j--;
                    skipT--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            } else if (i >= 0 || j >= 0){
                return false;
            }
            i--;
            j--;
        }
        return true;
    }
}
