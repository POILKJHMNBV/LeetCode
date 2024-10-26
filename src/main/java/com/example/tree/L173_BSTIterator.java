package com.example.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <p>L173:二叉搜索树迭代器</p>
 * @author zhenwu
 * @date 2024/10/26 21:25
 */
public class L173_BSTIterator {
    public static void main(String[] args) {

    }

    /**
     * 二叉搜索树迭代器
     * 时间复杂度：O(1)
     * 空间复杂度：O(h)
     */
    static class BSTIterator {

        private final Deque<TreeNode> stack = new LinkedList<>();

        private TreeNode cur;

        public BSTIterator(TreeNode root) {
            cur = root;
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int ret = cur.val;
            cur = cur.right;
            return ret;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }
}
