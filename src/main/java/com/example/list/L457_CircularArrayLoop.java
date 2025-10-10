package com.example.list;

/**
 * <p>L457:环形数组是否存在循环</p>
 * @author zhenwu
 * @date 2025/10/10 21:38
 */
public class L457_CircularArrayLoop {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n * n)
     * 空间复杂度：O(1)
     */
    private static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (check(nums, i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean check(int[] nums, int start) {
        int n = nums.length;
        int cur = start;
        boolean flag = nums[start] > 0;
        int k = 1;
        while (true) {
            if (k > n) return false;
            int next = ((cur + nums[cur]) % n + n ) % n;
            if (flag && nums[next] < 0) return false;
            if (!flag && nums[next] > 0) return false;
            if (next == start) return k > 1;
            cur = next;
            k++;
        }
    }
}
