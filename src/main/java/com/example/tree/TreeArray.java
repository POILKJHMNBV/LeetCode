package com.example.tree;

import java.util.Arrays;

/**
 * 树状数组
 * @author zhenwu
 * @date 2024/12/27 21:00
 */
public class TreeArray {
    private final int[] nodes;
    private final int[] nums;

    public TreeArray(int[] nums) {
        this.nodes = new int[nums.length + 1];
        this.nums = nums;
    }

    public TreeArray(int n) {
        this.nodes = new int[n + 1];
        this.nums = new int[n];
    }

    private int lowBit(int x) {
        return x & -x;
    }

    /**
     * 时间：O(n * logn)
     * 空间：O(n)
     * 初始化树状数组，将nums中的每个元素都加上去。
     */
    public void initTree(int[] nums) {
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
    public long prefixSum(int x) {
        long ans = 0;
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

    @Override
    public String toString() {
        return "TreeArray{" +
                "nodes=" + Arrays.toString(nodes) +
                '}';
    }
}
