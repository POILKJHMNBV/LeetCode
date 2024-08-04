package com.example.tree;

/**
 * <p>L114:二叉树展开为链表</p>
 * <p>展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。</p>
 */
public class L114_Flatten {
    public static void main(String[] args) {

    }

    private static TreeNode pre = null;

    /**
     * 递归
     */
    private static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    /**
     * 非递归
     * 将当前结点的左子树放在右子树的位置，右子树放在左子树的最右端
     */
    private static void flattenPro(TreeNode root) {
        if (root == null) {
            return;
        }
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
