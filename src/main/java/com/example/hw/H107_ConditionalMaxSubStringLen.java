package com.example.hw;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>求满足条件的最长子串的长度</p>
 * <p>
 *     给定一个字符串，只包含字母和数字，按要求找出字符串中的最长(连续)子的长度，字符串本身是其最长的子串，子串要求:
 *          1.只包含1个字母(az,AZ)，其余必须是数字;
 *          2.字母可以在子串中的任意位置;
 *     如果找不到满足要求的子串，如全是字母或全是数字，则返回-1。
 * </p>
 * <p>
 *     输入描述：字符串(只包含字母和数字)
 * </p>
 * <p>
 *     输出描述：子串的长度
 * </p>
 * @author zhenwu
 * @date 2024/7/27 10:57
 */
public class H107_ConditionalMaxSubStringLen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(resolve1(s));
        System.out.println(resolve2(s));
    }

    private static int resolve1(String s) {
        char[] chars = s.toCharArray();
        int l = 0, r = 0, len = chars.length;
        int maxSubStringLen = 0, letterCount = 0;
        while (r < len) {
            char ch = chars[r];
            if (Character.isLetter(ch)) {
                letterCount++;
                if (letterCount > 1) {
                    l = r;
                    letterCount = 1;
                    r++;
                    continue;
                }
            }
            maxSubStringLen = Math.max(maxSubStringLen, r - l + 1);
            r++;
        }
       return maxSubStringLen < 2 || letterCount == 0 ? -1 : maxSubStringLen;
    }

    private static int resolve2(String s) {
        Pattern pattern = Pattern.compile("\\d*[a-zA-Z]\\d*");
        Matcher matcher = pattern.matcher(s);
        int maxLength = -1;
        while (matcher.find()) { // 在文本中查找所有匹配项
            String match = matcher.group(); // 获取当前匹配项的字符串表示
            int length = match.length(); // 计算当前匹配项的长度
            maxLength = Math.max(maxLength, length); // 更新最大长度为当前匹配项的长度和已有最大长度中的较大者
        }
        return maxLength < 2 ? -1 : maxLength;
    }
}
