package com.example.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * L1305:两棵二叉搜索树中的所有元素
 * <p>
 * 给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序.
 * </p>
 */
public class L1305_GetAllElements {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(0);
        root2.right = new TreeNode(3);
        System.out.println(getAllElements(root1, root2));
    }

    private static List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        TreeNode cur1 = root1;
        TreeNode cur2 = root2;
        List<Integer> ans = new ArrayList<>();
        while ((cur1 != null || !stack1.isEmpty()) && (cur2 != null || !stack2.isEmpty())) {
            if (cur1 != null || cur2 != null) {
                if (cur1 != null) {
                    stack1.push(cur1);
                    cur1 = cur1.left;
                }
                if (cur2 != null) {
                    stack2.push(cur2);
                    cur2 = cur2.left;
                }
            } else {
                TreeNode treeNode1 = stack1.peek();
                TreeNode treeNode2 = stack2.peek();
                if (treeNode1.val < treeNode2.val) {
                    ans.add(treeNode1.val);
                    TreeNode node = stack1.pop();
                    cur1 = node.right;
                } else if (treeNode1.val > treeNode2.val) {
                    ans.add(treeNode2.val);
                    TreeNode node = stack2.pop();
                    cur2 = node.right;
                } else {
                    ans.add(treeNode1.val);
                    TreeNode node1 = stack1.pop();
                    cur1 = node1.right;
                    ans.add(treeNode2.val);
                    TreeNode node2 = stack2.pop();
                    cur2 = node2.right;
                }
            }
        }
        lvr(cur1, stack1, ans);
        lvr(cur2, stack2, ans);
        return ans;
    }

    private static void lvr(TreeNode cur, Deque<TreeNode> stack, List<Integer> ans) {
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode treeNode = stack.pop();
                ans.add(treeNode.val);
                cur = treeNode.right;
            }
        }
    }
}
