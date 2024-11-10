package com.example.tree;

/**
 * <p>L235:二叉搜索树的最近公共祖先</p>
 * @author zhenwu
 * @date 2024/11/10 21:39
 * @see L236_LowestCommonAncestor
 */
public class L235_LowestCommonAncestor {
    public static void main(String[] args) {

    }

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果根节点和p,q的差相乘是正数，说明这两个差值要么都是正数要么都是负数，也就是说
        //他们肯定都位于根节点的同一侧，就继续往下找
        int a = root.val - p.val, b = root.val - q.val;
        while ((a > 0 && b > 0) || (a < 0 && b < 0)) {
            root = p.val < root.val ? root.left : root.right;
            a = root.val - p.val;
            b = root.val - q.val;
        }
        //如果相乘的结果是负数，说明p和q位于根节点的两侧，如果等于0，说明至少有一个就是根节点
        return root;
    }
}
