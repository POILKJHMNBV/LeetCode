package com.example.tree;

/**
 * <p>L951:翻转等价二叉树</p>
 * @author zhenwu
 * @date 2025/10/24 23:24
 */
public class L951_FlipEquiv {
    public static void main(String[] args) {

    }

    /**
     * dfs
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
