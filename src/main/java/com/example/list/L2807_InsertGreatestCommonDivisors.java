package com.example.list;

/**
 * <p>L2907:在链表中插入最大公约数</p>
 * @author zhenwu
 * @date 2025/10/7 14:44
 */
public class L2807_InsertGreatestCommonDivisors {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            int a = cur.val, b = cur.next.val;
            cur.next = new ListNode(gcd(a, b), cur.next);
            cur = cur.next.next;
        }
        return head;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
