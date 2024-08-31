package com.example.doublepointer;

/**
 * <p>L443:压缩字符串</p>
 * @author zhenwu
 * @date 2024/8/31 15:01
 */
public class L443_Compress {
    public static void main(String[] args) {
        System.out.println(compress("abbbbbbbbbbb".toCharArray()));
        System.out.println(compressPro("abbbbbbbbbbb".toCharArray()));
    }

    private static int compressPro(char[] chars) {
        int left = 0, right = 0;
        while (right < chars.length) {
            chars[left++] = chars[right];
            char target = chars[right];
            int count = 0;
            while (right < chars.length && chars[right] == target) {
                right++;
                count++;
            }
            if (count != 1) {
                for (char ch : String.valueOf(count).toCharArray()) {
                    chars[left++] = ch;
                }
            }
        }
        return left;
    }

    private static int compress(char[] chars) {
        int len = 0, j = 0;
        StringBuilder res = new StringBuilder();
        while (j < chars.length) {
            int count = 0;
            len++;
            char target = chars[j];
            res.append(target);
            while (j < chars.length && chars[j] == target) {
                j++;
                count++;
            }
            if (count != 1) {
                res.append(count);
                len += String.valueOf(count).length();
            }
        }
        for (int i = 0; i < len; i++) {
            chars[i] = res.charAt(i);
        }
        return len;
    }
}
