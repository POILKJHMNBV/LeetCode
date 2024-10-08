package com.example.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L872:叶子相似的树</p>
 * @author zhenwu
 * @date 2024/9/7 15:52
 */
public class L872_LeafSimilar {
    public static void main(String[] args) {

    }

    private static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> seq1 = new ArrayList<>();
        if (root1 != null) {
            dfs(root1, seq1);
        }

        List<Integer> seq2 = new ArrayList<>();
        if (root2 != null) {
            dfs(root2, seq2);
        }

        return seq1.equals(seq2);
    }

    private static void dfs(TreeNode node, List<Integer> seq) {
        if (node.left == null && node.right == null) {
            seq.add(node.val);
        } else {
            if (node.left != null) {
                dfs(node.left, seq);
            }
            if (node.right != null) {
                dfs(node.right, seq);
            }
        }
    }
}
