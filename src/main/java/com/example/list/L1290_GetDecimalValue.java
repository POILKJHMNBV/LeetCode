package com.example.list;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L1290:二进制链表转整数</p>
 * @author zhenwu
 * @date 2025/9/30 21:10
 */
public class L1290_GetDecimalValue {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int getDecimalValue(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int ans = 0, size = nums.size(), n = size - 1;
        for (int i = 0; i < size; i++) {
            ans += nums.get(i) * Math.pow(2, n - i);
        }
        return ans;
    }
}
