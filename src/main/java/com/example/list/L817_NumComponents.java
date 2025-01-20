package com.example.list;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>L817:链表组件</p>
 * @author zhenwu
 * @date 2025/1/20 21:49
 */
public class L817_NumComponents {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int count = 0;
        while (head != null) {
            int step = 0;
            while (head != null && set.contains(head.val)) {
                step++;
                head = head.next;
            }
            if (step != 0) {
                count++;
            }
            if (head != null) {
                head = head.next;
            }
        }
        return count;
    }
}
