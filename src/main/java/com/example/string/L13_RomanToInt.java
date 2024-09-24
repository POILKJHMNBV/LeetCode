package com.example.string;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L13:罗马数字转整数</p>
 * @author zhenwu
 * @date 2024/9/24 20:50
 */
public class L13_RomanToInt {
    public static void main(String[] args) {
        String s = "IV";
        System.out.println(romanToInt(s));
    }

    private static final Map<Character, Integer> map;

    static {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    /**
     * 时间复杂度：O(n)  空间复杂度：O(1)
     */
    private static int romanToInt(String s) {
        int result = 0;
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        result += map.get(charArray[0]);
        for (int i = 1; i < len; i++) {
            int pre = map.get(charArray[i - 1]);
            int cur = map.get(charArray[i]);
            result += cur;
            if (pre < cur) {
                result -= 2 * pre;
            }
        }
        return result;
    }
}
