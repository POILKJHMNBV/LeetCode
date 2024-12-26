package com.example.array;

import java.util.Arrays;

/**
 * <p>L307:区域和检索 - 数组可修改</p>
 * @author zhenwu
 * @date 2024/12/3 21:38
 */
public class L307_NumArray {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        System.out.println(Arrays.stream(nums).sum());
        TreeArray treeArray = new TreeArray(nums);
        System.out.println(treeArray.prefixSum(5));
        treeArray.set(3, 2);
        System.out.println(treeArray.prefixSum(5));
    }


    /**
     * 树状数组
     */
    static class TreeArray {
        private final int[] nodes;
        private final int[] nums;

        public TreeArray(int[] nums) {
            this.nodes = new int[nums.length + 1];
            this.nums = nums;
            initTree(nums);
            System.out.println(Arrays.toString(nodes));
        }
        
        private int lowBit(int x) {
            return x & -x;
        }

        /**
         * 时间：O(n * logn)
         * 空间：O(n)
         * 初始化树状数组，将nums中的每个元素都加上去。
         */
        private void initTree(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }

        /**
         * 时间：O(logn)
         * 空间：O(1)
         */
        public void set(int x, int u) {
            add(x + 1, u - nums[x]);
            nums[x] = u;
        }

        /**
         * 时间：O(logn)
         * 空间：O(1)
         */
        public int prefixSum(int x) {
            int ans = 0;
            // 此处判断条件一定是 i > 0，而不能是 i >= 0
            for (int i = x; i > 0; i -= lowBit(i)) {
                ans += nodes[i];
            }
            return ans;
        }

        /**
         * 时间：O(logn)
         * 空间：O(1)
         */
        public void add(int x, int u) {
            for (int i = x; i < nodes.length; i += lowBit(i)) {
                nodes[i] += u;
            }
        }
    }

    /**
     * 线段树
     */
    static class NumArray {

        private final int[] segmentTree;
        private final int n;

        public NumArray(int[] nums) {
            n = nums.length;
            segmentTree = new int[nums.length * 4];
            build(0, 0, n - 1, nums);
        }

        public void update(int index, int val) {
            change(index, val, 0, 0, n - 1);
        }

        public int sumRange(int left, int right) {
            return range(left, right, 0, 0, n - 1);
        }

        private void build(int node, int s, int e, int[] nums) {
            if (s == e) {
                segmentTree[node] = nums[s];
                return;
            }
            int m = s + (e - s) / 2;
            build(node * 2 + 1, s, m, nums);
            build(node * 2 + 2, m + 1, e, nums);
            segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
        }

        private void change(int index, int val, int node, int s, int e) {
            if (s == e) {
                segmentTree[node] = val;
                return;
            }
            int m = s + (e - s) / 2;
            if (index <= m) {
                change(index, val, node * 2 + 1, s, m);
            } else {
                change(index, val, node * 2 + 2, m + 1, e);
            }
            segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
        }

        private int range(int left, int right, int node, int s, int e) {
            if (left == s && right == e) {
                return segmentTree[node];
            }
            int m = s + (e - s) / 2;
            if (right <= m) {
                return range(left, right, node * 2 + 1, s, m);
            } else if (left > m) {
                return range(left, right, node * 2 + 2, m + 1, e);
            } else {
                return range(left, m, node * 2 + 1, s, m) + range(m + 1, right, node * 2 + 2, m + 1, e);
            }
        }
    }
}
