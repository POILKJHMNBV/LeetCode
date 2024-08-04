package com.example.hw;

import com.example.tree.L105_BuildTree;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>二叉树计算</p>
 * <p>
 *     给出一个二叉树，请由该二叉树生成一个新的二叉树，它满足其树中的每个节点将包含原始树中的左子树和右子树的和。
 * </p>
 * <p>
 *     输入描述：2行整数，第1行表示二叉树的中序遍历，第2行表示二叉树的前序遍历，以空格分割
 *     输出描述：1行整数，表示求和树的中序遍历，以空格分割
 * </p>
 * @see L105_BuildTree
 * @author zhenwu
 * @date 2024/7/16 21:51
 */
public class H58_CalculateBinaryTree {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] inorder = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] preorder = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        TreeNode root = buildBinaryTreeByIP(inorder, 0, inorder.length - 1,
                preorder, 0, preorder.length - 1);
        vlr(root);
        lvr(root);
    }

    /**
     * 中序遍历输出结果
     * @param root 二叉树
     */
    private static void lvr(TreeNode root) {
        if (root == null) {
            return;
        }
        lvr(root.left);
        System.out.print(root.sum + " ");
        lvr(root.right);
    }

    /**
     * 后序遍历二叉树，求取子树和
     * @param root 二叉树
     * @return 子树和
     */
    private static int vlr(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = vlr(root.left);
        int rightSum = vlr(root.right);
        root.sum = leftSum + rightSum;
        return root.sum + root.item;
    }

    /**
     * 根据中序遍历和前序遍历的结果构建二叉树
     * @param inorder 二叉树的中序遍历结果
     * @param inLeft 中序遍历子树左边界
     * @param inRight 中序遍历子树右边界
     * @param preorder 二叉树的前序遍历结果
     * @param preLeft 前序遍历子树左边界
     * @param preRight 前序遍历子树右边界
     * @return 二叉树
     */
    private static TreeNode buildBinaryTreeByIP(int[] inorder, int inLeft, int inRight,
                                                int[] preorder, int preLeft, int preRight) {
        if (inLeft > inRight || preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preLeft]);
        int pivot = inLeft;
        while (inorder[pivot] != preorder[preLeft]) {
            // 找到根节点在中序遍历中的位置
            pivot++;
        }
        root.left = buildBinaryTreeByIP(inorder, inLeft, pivot - 1,
                                        preorder, preLeft + 1, preLeft + pivot - inLeft);
        root.right = buildBinaryTreeByIP(inorder, pivot + 1, inRight,
                preorder, preLeft + pivot - inLeft + 1, preRight);
        return root;
    }


    private static class TreeNode {
        final int item;
        int sum;
        TreeNode left, right;

        public TreeNode(int item) {
            this.item = item;
        }
    }
}
