package com.example.list;

import java.util.Arrays;

/**
 * <p>L2058:找出临界点之间的最小和最大距离</p>
 * @author zhenwu
 * @date 2025/10/1 20:19
 */
public class L2058_NodesBetweenCriticalPoints {
    public static void main(String[] args) {
        ListNode head = ListUtil.buildSingleList(new int[]{2, 3, 3, 2, 2, 2});
        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head)));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    private static int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[]{Integer.MAX_VALUE, -1};
        int pre = head.val;
        head = head.next;
        int cur = head.val;
        if (head.next == null || head.next.next == null) {
            // 临界点数量小于2
            return new int[]{-1, -1};
        }
        int headIndex = -1, preIndex = -1, index = 1, lastIndex = -1;
        while (head.next != null) {
            int next = head.next.val;
            if (isMaximumOrMinimum(pre, cur, next)) {
                if (headIndex == -1) {
                    headIndex = index;
                }
                if (preIndex != -1) {
                    ans[0] = Math.min(ans[0], index - preIndex);
                }
                preIndex = index;
                lastIndex = index;
            }
            index++;
            pre = cur;
            head = head.next;
            cur = head.val;
        }
        if (headIndex < 0 || lastIndex < 0 || headIndex == lastIndex) {
            return new int[]{-1, -1};
        }
        ans[1] = lastIndex - headIndex;
        return ans;
    }

    private static boolean isMaximumOrMinimum(int prev, int cur, int next) {
        return (prev < cur && cur > next) || (prev > cur && cur < next);
    }
}
