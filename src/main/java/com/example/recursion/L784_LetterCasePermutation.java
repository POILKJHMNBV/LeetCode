package com.example.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenwu
 * @date 2024/12/20 20:05
 */
public class L784_LetterCasePermutation {
    public static void main(String[] args) {
        String s = "a1b2";
        System.out.println(letterCasePermutation(s));
    }

    private static List<String> letterCasePermutation(String s) {
        char[] charArray = s.toCharArray();
        List<String> result = new ArrayList<>();
        dfs(charArray, 0, "", result);
        return result;
    }

    /**
     * 位运算
     */
    private static void dfs(char[] charArray, int index, List<String> result) {
        if (index == charArray.length) {
            result.add(new String(charArray));
            return;
        }
        dfs(charArray, index + 1, result);
        if (Character.isLetter(charArray[index])) {
            charArray[index] ^= 32;
            dfs(charArray, index + 1, result);
        }
    }

    private static void dfs(char[] charArray, int index, String s, List<String> result) {
        if (index == charArray.length) {
            result.add(s);
            return;
        }
        char c = charArray[index];
        if (Character.isLetter(c)) {
            dfs(charArray, index + 1, s + Character.toLowerCase(c), result);
            dfs(charArray, index + 1, s + Character.toUpperCase(c), result);
        } else {
            dfs(charArray, index + 1, s + c, result);
        }
    }
}
