package com.example.slidewindow;

/**
 * <p>L1248: 统计「优美子数组」</p>
 * @author zhenwu
 * @date 2025/2/22 10:13
 */
public class L1248_NumberOfSubarrays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));
    }

    /**
     * 滑动窗口，维护两个计数器cnt1和cnt2。
     * cnt1表示窗口内奇数个数，当大于k时，左指针向右移动直到小于等于k。
     * cnt2表示窗口内奇数个数大于等于k时，左指针向右移动直到小于k。
     * res累加 l2 - l1。
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int cnt1 = 0, cnt2 = 0;
        for (int l1 = 0, l2 = 0, r = 0, n = nums.length; r < n; r++) {
            if (nums[r] % 2 == 1) {
                cnt1++;
                cnt2++;
            }
            while (l1 <= r && cnt1 > k) {
                if (nums[l1++] % 2 == 1) {
                    cnt1--;
                }
            }
            while (l2 <= r && cnt2 >= k) {
                if (nums[l2++] % 2 == 1) {
                    cnt2--;
                }
            }
            res += l2 - l1;
        }
        return res;
    }
}
