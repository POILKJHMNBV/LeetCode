package com.example.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树工具类
 */
public final class BinaryTreeUtil {
    private BinaryTreeUtil(){}

    /**
     * 先序遍历二叉树(递归实现)
     */
    public static List<Integer> vlrRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        vlrRecursion(root, res);
        return res;
    }

    private static void vlrRecursion(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        vlrRecursion(root.left, res);
        vlrRecursion(root.right, res);
    }

    /**
     * 先序遍历二叉树(栈实现)
     */
    public static List<Integer> vlrStack(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            res.add(treeNode.val);
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
        return res;
    }

    /**
     * 中序遍历二叉树(递归实现)
     */
    public static List<Integer> lvrRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        lvrRecursion(root, res);
        return res;
    }

    private static void lvrRecursion(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        vlrRecursion(root.left, res);
        res.add(root.val);
        vlrRecursion(root.right, res);
    }

    /**
     * 中序遍历二叉树(栈实现)
     */
    public static List<Integer> lvrStack(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode treeNode = stack.pop();
                res.add(treeNode.val);
                root = treeNode.right;
            }
        }
        return res;
    }

    /**
     * 后序遍历二叉树(递归实现)
     */
    public static List<Integer> lrvRecursion(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        lrvRecursion(root, res);
        return res;
    }

    private static void lrvRecursion(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        vlrRecursion(root.left, res);
        vlrRecursion(root.right, res);
        res.add(root.val);
    }

    /**
     * 后序遍历二叉树(一个栈实现)
     */
    public static List<Integer> lrvSingleStack(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode peekNode = stack.peek();
                if (peekNode.right != null && pre != peekNode.right) {
                    root = peekNode.right;
                } else {
                    TreeNode treeNode = stack.pop();
                    res.add(treeNode.val);
                    pre = treeNode;
                }
            }
        }
        return res;
    }

    /**
     * 后序遍历二叉树(两个栈实现)
     */
    public static List<Integer> lrvDoubleStack(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> res = new ArrayList<>();
        ArrayDeque<TreeNode> stack1 = new ArrayDeque<>();
        ArrayDeque<Integer> stack2 = new ArrayDeque<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode treeNode = stack1.pop();
            stack2.push(treeNode.val);
            if (treeNode.left != null) {
                stack1.push(treeNode.left);
            }
            if (treeNode.right != null) {
                stack1.push(treeNode.right);
            }
        }

        while (!stack2.isEmpty()) {
            res.add(stack2.pop());
        }
        return res;
    }
}
