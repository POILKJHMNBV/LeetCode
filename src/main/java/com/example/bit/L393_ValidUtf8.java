package com.example.bit;

/**
 * <p>L393:UTF-8 编码验证</p>
 * @author zhenwu
 * @date 2025/1/8 20:35
 */
public class L393_ValidUtf8 {
    public static void main(String[] args) {
        int[] data = {230, 136, 145};
        System.out.println(validUtf8(data));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static boolean validUtf8(int[] data) {
        int n = data.length, i = 0;
        while (i < n) {
            int a = 1 << 7;
            if ((a & data[i]) == 0) {
                i++;
            } else {
                int oneCount = 0, k = 7;
                while (k >= 0 && ((data[i] >> k) & 1) == 1) {
                    k--;
                    oneCount++;
                    if (oneCount > 4) {
                        return false;
                    }
                }
                if (oneCount == 1 || i + oneCount > n) {
                    return false;
                }
                for (int j = i + 1; j < (i + oneCount); j++) {
                    if (((data[j] >> 7) & 1) == 0) {
                        return false;
                    }
                    if (((data[j] >> 6) & 1) == 1) {
                        return false;
                    }
                }
                i += oneCount;
            }
        }
        return true;
    }
}
