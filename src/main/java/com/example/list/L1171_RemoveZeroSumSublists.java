package com.example.list;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>L1171:从链表中删去总和值为零的连续节点</p>
 * @author zhenwu
 * @date 2025/10/13 21:23
 */
public class L1171_RemoveZeroSumSublists {
    public static void main(String[] args) {

    }

    /**
     * 思路：链表中出现连续节点总和为0的节点，则该子链表节点 起始节点的前缀和 = 终止节点下一个节点的前缀和
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    private static ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        Map<Integer, ListNode> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        for (ListNode node = dummyNode; node != null; node = node.next) {
            prefixSum += node.val;
            prefixSumMap.put(prefixSum, node);
        }
        prefixSum = 0;
        for (ListNode node = dummyNode; node != null; node = node.next) {
            prefixSum += node.val;
            node.next = prefixSumMap.get(prefixSum).next;
        }
        return dummyNode.next;
    }
}
