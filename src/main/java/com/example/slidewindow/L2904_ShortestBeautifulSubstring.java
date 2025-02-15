package com.example.slidewindow;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L2904:最短且字典序最小的美丽子字符串</p>
 * @author zhenwu
 * @date 2025/2/15 9:47
 */
public class L2904_ShortestBeautifulSubstring {
    public static void main(String[] args) {
        String s = "100011001";
        int k = 3;
        System.out.println(shortestBeautifulSubstring(s, k));
    }

    /**
     * 滑动窗口
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static String shortestBeautifulSubstring(String s, int k) {
        char[] charArray = s.toCharArray();
        List<String> list = new ArrayList<>();
        int n = charArray.length, minLen = n;
        for (int l = 0, r = 0, cnt = 0; r < n; r++) {
            if (charArray[r] == '1') {
                cnt++;
            }
            while (cnt > k || charArray[l] == '0' && l < r) {
                if (charArray[l] == '1') {
                    cnt--;
                }
                l++;
            }
            if (cnt == k) {
                if (r - l + 1 <= minLen) {
                    if (r - l + 1 < minLen) {
                        minLen = r - l + 1;
                        list.clear();
                    }
                    list.add(s.substring(l, r + 1));
                }
            }
        }
        list.sort(String::compareTo);
        return list.isEmpty() ? "" : list.get(0);
    }
}
