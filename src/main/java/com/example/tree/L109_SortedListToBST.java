package com.example.tree;

import com.example.list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L109:有序链表转换二叉搜索树</p>
 * @author zhenwu
 * @date 2024/10/9 21:58
 */
public class L109_SortedListToBST {
    public static void main(String[] args) {

    }

    /**
     * 时间：O(n)   空间：O(n)
     */
    private static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        return buildBST(nums, 0, nums.size() - 1);
    }

    private static TreeNode buildBST(List<Integer> nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = buildBST(nums, start, mid - 1);
        root.right = buildBST(nums, mid + 1, end);
        return root;
    }
}
