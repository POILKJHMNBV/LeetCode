package com.example.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * <p>L382:链表随机节点</p>
 * @author zhenwu
 * @date 2025/10/14 21:31
 */
public class L382_RandomList {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static class Solution {
        private final List<Integer> list;
        private final Random random;

        public Solution(ListNode head) {
            list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            random = new Random();
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
