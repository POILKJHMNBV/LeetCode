package com.example.tree;

/**
 * <P>L1379:找出克隆二叉树中的相同节点</P>
 * @author zhenwu
 * @date 2025/10/25 15:05
 */
public class L1379_GetTargetCopy {
    public static void main(String[] args) {

    }

    /**
     * dfs
     * 时间复杂度: O(n)
     * 空间复杂度: O(n)
     */
    private static TreeNode getTargetCopy(final TreeNode original,
                                          final TreeNode cloned,
                                          final TreeNode target) {
        if (target == original) {
            return cloned;
        }
        if (original.left != null) {
            TreeNode left = getTargetCopy(original.left, cloned.left, target);
            if (left != null) {
                return left;
            }
        }
        if (original.right != null) {
            return getTargetCopy(original.right, cloned.right, target);
        }
        return null;
    }
}
