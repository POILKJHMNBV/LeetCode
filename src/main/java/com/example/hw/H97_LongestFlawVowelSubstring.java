package com.example.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>最长的指定瑕疵度的元音子串</p>
 * <p>
 *     开头和结尾都是元音字母（aeiouAEIOU）的字符串为元音字符串，其中混杂的非元音字母数量为其瑕疵度。比如:
 *          1.“a” 、 “aa” 是元音字符串，其瑕疵度都为0
 *          2.“aiur” 不是元音字符串（结尾不是元音字符）
 *          3.“abira” 是元音字符串，其瑕疵度为2
 *     给定一个字符串，请找出指定瑕疵度的最长元音字符子串，并输出其长度，如果找不到满足条件的元音字符子串，输出0。
 *     子串：字符串中任意个连续的字符组成的子序列称为该字符串的子串。
 * </p>
 * <p>
 *     输入描述：
 *          首行输入是一个整数，表示预期的瑕疵度flaw，取值范围[0, 65535]。
 *          接下来一行是一个仅由字符a-z和A-Z组成的字符串，字符串长度(0, 65535]。
 * </p>
 * <p>
 *     输出描述：
 *          输出为一个整数，代表满足条件的元音字符子串的长度。
 * </p>
 * @author zhenwu
 * @date 2024/7/24 21:25
 */
public class H97_LongestFlawVowelSubstring {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int flaw = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        System.out.println(maxLenFlawVowelSubstring(flaw, s));
        System.out.println(maxLenFlawVowelSubstringPro(flaw, s));
    }

    private static final Set<Character> vowelSet;

    static {
        vowelSet = "aeiouAEIOU".chars().mapToObj(num -> (char) num).collect(Collectors.toSet());
    }

    /**
     * 滑动窗口求解
     * @param flaw 瑕疵度
     * @param s 目标字符串
     * @return 瑕疵度的最长元音字符子串长度
     */
    private static int maxLenFlawVowelSubstringPro(int flaw, String s) {
        int len = s.length();

        // 瑕疵度表，记录每个位置前i个字符的瑕疵
        int[] flawCounter = new int[len + 1];

        // 保存元音字母的索引，便于后面进行滑动窗口求解
        List<Integer> vowelIndexList = new ArrayList<>();

        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (vowelSet.contains(chars[i])) {
                vowelIndexList.add(i);
            } else {
                count++;
            }
            flawCounter[i + 1] = count;
        }

        int maxLen = 0, left = 0;
        for (int right = 0; right < vowelIndexList.size(); right++) {
            // left与right组成的滑动窗口内的字符串一定是元音字符子串
            int rightIndex = vowelIndexList.get(right);

            while (left <= right) {
                int leftIndex = vowelIndexList.get(left);

                // 计算滑动窗口内元音字符子串瑕疵度
                int curFlaw = flawCounter[rightIndex + 1] - flawCounter[leftIndex];
                if (curFlaw > flaw) {
                    // 瑕疵度太大，收缩窗口
                    left++;
                    continue;
                }
                if (curFlaw == flaw) {
                    maxLen = Math.max(maxLen, rightIndex - leftIndex + 1);
                }
                // 滑动窗口内元音字符子串瑕疵度太小或已经找到结果，退出循环
                break;
            }
        }

        return maxLen;
    }

    /**
     * 暴力求解
     * @param flaw 瑕疵度
     * @param s 目标字符串
     * @return 瑕疵度的最长元音字符子串长度
     */
    private static int maxLenFlawVowelSubstring(int flaw, String s) {
        char[] chars = s.toCharArray();
        int len = s.length();
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (calculateFlaw(chars, i, j) == flaw) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;
    }

    private static int calculateFlaw(char[] chars, int l, int r) {
        int flaw = 0;
        for (int i = l; i <= r; i++) {
            if (!vowelSet.contains(chars[i])) {
                flaw++;
            }
        }
        return flaw;
    }
}
