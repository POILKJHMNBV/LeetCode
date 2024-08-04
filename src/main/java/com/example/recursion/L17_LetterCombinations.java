package com.example.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>L17:电话号码的字母组合</p>
 * <p>给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母</p>
 */
public class L17_LetterCombinations {
    public static void main(String[] args) {
        String digits = "234";
        System.out.println(letterCombinations(digits));
        int[] nums = new int[33];
        for (int i = 0; i < 33; i++) {
            nums[i] = i + 1;
        }
        System.out.println(Arrays.toString(nums ));
    }

    private static final String[] letterArray = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        process(digits, 0, "", res);
        return res;
    }

    /**
     *
     * @param digits 包含数字的字符串
     * @param index 当前要娶数字的索引
     * @param s 当前字符
     * @param res 收集结果
     */
    private static void process(String digits, int index, String s, List<String> res) {
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        int digit = digits.charAt(index) - '0';
        String letter = letterArray[digit];
        for (int i = 0; i < letter.length(); i++) {
            process(digits, index + 1, s + letter.charAt(i), res);
        }
    }
}
