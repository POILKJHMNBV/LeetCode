package com.example.string;

/**
 * <p>L165:比较版本号</p>
 * @author zhenwu
 * @date 2024/10/23 20:22
 */
public class L165_CompareVersion {
    public static void main(String[] args) {

    }

    /**
     * 比较版本号
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(n + m)
     * @param version1 版本号1
     * @param version2 版本号2
     */
    private static int compareVersion(String version1, String version2) {
        String[] strArray1 = version1.split("\\.");
        String[] strArray2 = version2.split("\\.");
        int len1 = strArray1.length, len2 = strArray2.length;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            int a = Integer.parseInt(strArray1[i]), b = Integer.parseInt(strArray2[j]);
            if (a > b) {
                return 1;
            } else if (a < b) {
                return -1;
            } else {
                i++;
                j++;
            }
        }
        if (i < len1) {
            for (int k = i; k < len1; k++) {
                if (Integer.parseInt(strArray1[k]) > 0) {
                    return 1;
                }
            }
        }
        if (j < len2) {
            for (int k = j; k < len2; k++) {
                if (Integer.parseInt(strArray2[k]) > 0) {
                    return -1;
                }
            }
        }
        return 0;
    }
}
