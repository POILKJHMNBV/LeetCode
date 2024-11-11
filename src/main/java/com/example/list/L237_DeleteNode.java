package com.example.list;

/**
 * <p>L237:删除链表中的节点</p>
 * @author zhenwu
 * @date 2024/11/11 21:40
 */
public class L237_DeleteNode {
    public static void main(String[] args) {

    }

    /**
     * 删除节点
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     */
    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
