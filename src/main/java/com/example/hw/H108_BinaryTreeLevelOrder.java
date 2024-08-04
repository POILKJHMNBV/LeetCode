package com.example.hw;

import com.example.tree.L102_LevelOrder;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * <p>二叉树的广度优先遍历</p>
 * <p>
 *     有一棵二叉树，每个节点由一个大写字母标识(最多26个节点）。
 *     现有两组字母，分别表示后序遍历（左孩子->右孩子->父节点）和中序遍历（左孩子->父节点->右孩子）的结果，请输出层次遍历的结果。
 * </p>
 * <p>
 *     输入描述：输入为两个字符串，分别是二叉树的后续遍历和中序遍历结果。
 * </p>
 * <p>
 *     输出描述：输出二叉树的层次遍历结果。
 * </p>
 * @author zhenwu
 * @date 2024/7/27 15:00
 * @see L102_LevelOrder
 */
public class H108_BinaryTreeLevelOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] postOrder = in.next().toCharArray();
        char[] inOrder = in.next().toCharArray();
        TreeNode root = buildBinaryTreePI(postOrder, 0, postOrder.length - 1,
                inOrder, 0, inOrder.length - 1);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            System.out.print(treeNode.Item);
            if (treeNode.left != null) {
                queue.offer(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.offer(treeNode.right);
            }
        }
    }

    private static TreeNode buildBinaryTreePI(char[] postOrder, int postLeft, int postRight,
                                              char[] inOrder, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(postOrder[postRight]);
        int pivot = inLeft;
        while (inOrder[pivot] != postOrder[postRight]) {
            // 寻找根节点在中序遍历的位置
            pivot++;
        }
        root.left = buildBinaryTreePI(postOrder, postLeft, postLeft + pivot - inLeft - 1,
                                    inOrder, inLeft, pivot - 1);
        root.right = buildBinaryTreePI(postOrder, postLeft + pivot - inLeft, postRight - 1,
                                        inOrder, pivot + 1, inRight);
        return root;
    }

    private static class TreeNode {
        final char Item;
        TreeNode left, right;
        public TreeNode(char item) {
            Item = item;
        }
    }
}
