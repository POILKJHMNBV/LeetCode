package com.example.tree;

/**
 * <p>L450:删除二叉搜索树中的节点</p>
 * @author zhenwu
 * @date 2024/8/26 19:58
 */
public class L450_DeleteNode {
    public static void main(String[] args) {

    }

    private static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            // 待删除的节点在左子树
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            // 待删除的节点在右子树
            root.right = deleteNode(root.right, key);
        } else {
            // 找到了待删除的节点
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    // 寻找左子树的最小节点
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }
        return root;
    }
}
