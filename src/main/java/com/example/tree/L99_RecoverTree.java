package com.example.tree;

import java.util.ArrayDeque;
import java.util.List;

/**
 * <p>L99:恢复二叉搜索树</p>
 * @author zhenwu
 * @date 2024/10/7 20:53
 */
public class L99_RecoverTree {
    public static void main(String[] args) {

    }

    /**
     * 时间：O(n)   空间：O(h)    h为树高
     * <p>用变量记录两个错误节点，然后交换值，只需一次中序遍历</p>
     * <p>如果整个中序遍历的序列中“逆序对”为一对，那么互换节点为该“逆序对”的两个成员；
     * 若“逆序对”数量为两对，则互换节点为「第一对“逆序对”的首个节点」和「第二对“逆序对”的第二个节点」</p>
     */
    public static void recoverTreePro(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode x = null, y = null, pred = null;
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();

                // 存在一个节点比前面某一个节点小，即存在逆序对
                if (pred != null && root.val < pred.val) {
                    y = root;
                    if (x == null) {
                        x = pred;
                    }
                }
                pred = root;
                root = root.right;
            }
        }
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }

    /**
     * 时间：O(n * log n)   空间：O(n)
     */
    private static void recoverTree(TreeNode root) {
        List<Integer> list = BinaryTreeUtil.lvrStack(root);
        list.sort(Integer::compareTo);
        recoverTree(root, list);
    }

    static int index = 0;

    private static void recoverTree(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        recoverTree(root.left, list);
        root.val = list.get(index++);
        recoverTree(root.right, list);
    }
}
