package com.example.array;

/**
 * <p>L2748:美丽下标对的数目</p>
 * @author zhenwu
 * @date 2025/5/2 9:49
 */
public class L2748_CountBeautifulPairs {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 4};
        System.out.println(countBeautifulPairs(nums));
    }

    /**
     * 时间复杂度：O(n⋅(k+logU))，其中 n 为 nums 的长度，k=10，U=max(nums)。计算 GCD 的时间视作 O(1)。
     * 空间复杂度：O(1)
     */
    private static int countBeautifulPairs(int[] nums) {
        int[] cnt = new int[10];
        int ans = 0;
        for (int num : nums) {
            int b = num % 10;
            for (int i = 1; i <= 9; i++) {
                if (gcd(i, b) == 1) {
                    ans += cnt[i];
                }
            }
            cnt[getHighestDigit(num)]++;
        }
        return ans;
    }

    private static int getHighestDigit(int num) {
        while (num >= 10) {
            num /= 10;
        }
        return num;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
