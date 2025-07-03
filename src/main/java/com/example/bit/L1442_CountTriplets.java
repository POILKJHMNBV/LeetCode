package com.example.bit;

/**
 * <p>L1442:形成两个异或相等数组的三元组数目</p>
 * @author zhenwu
 * @date 2025/7/3 21:59
 */
public class L1442_CountTriplets {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(n * n)
     * 空间复杂度: O(n)
     */
    private static int countTriplets(int[] arr) {
        int n = arr.length;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            s[i + 1] = s[i] ^ arr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int k = i + 1; k < n; ++k) {
                if (s[i] == s[k + 1]) {
                    ans += k - i;
                }
            }
        }
        return ans;
    }
}
