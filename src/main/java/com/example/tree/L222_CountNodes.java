package com.example.tree;

/**
 * <p>L222:完全二叉树的节点个数</p>
 * @author zhenwu
 * @date 2024/8/22 21:44
 */
public class L222_CountNodes {
    public static void main(String[] args) {

    }

    private static int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }

        // 计算左右子树的层级
        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);

        if (leftLevel == rightLevel) {
            // 左子树是满二叉树
            return countNodes(root.right) + (1 << leftLevel);
        } else {
            // 右子树是满二叉树
            return countNodes(root.left) + (1 << rightLevel);
        }
    }

    private static int countLevel(TreeNode root) {
        int level = 0;
        while (root != null) {
            level++;
            root = root.left;
        }
        return level;
    }
}
