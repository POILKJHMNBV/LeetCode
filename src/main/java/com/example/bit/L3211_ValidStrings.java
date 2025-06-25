package com.example.bit;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L3211:生成不含相邻零的二进制字符串</p>
 * @author zhenwu
 * @date 2025/6/25 22:26
 */
public class L3211_ValidStrings {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(2 ^ n)
     * 空间复杂度: O(1)
     */
    private static List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        int mask = (1 << n) - 1;
        for (int x = 0; x < (1 << n); x++) {
            if (((x >> 1) & x) == 0) {
                int i = x ^ mask;
                // 一种生成前导零的写法：在 i 前面插入 1<<n，转成字符串后再去掉插入的 1<<n
                ans.add(Integer.toBinaryString((1 << n) | i).substring(1));
            }
        }
        return ans;
    }
}
