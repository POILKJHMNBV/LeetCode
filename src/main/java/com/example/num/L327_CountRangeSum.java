package com.example.num;

import com.example.tree.TreeArray;

/**
 * <p>L327:区间和的个数</p>
 * @author zhenwu
 * @date 2024/12/7 10:11
 */
public class L327_CountRangeSum {
    public static void main(String[] args) {
        int[] nums = {0, -3, -3, 1, 1, 2};
        int lower = 3;
        int upper = 5;
        System.out.println(countRangeSumPro(nums, lower, upper));
        System.out.println(countRangeSumPlus(nums, lower, upper));
    }

    private static int countRangeSumPlus(int[] nums, int lower, int upper) {
        TreeArray treeArray = new TreeArray(nums.length);
        treeArray.initTree(nums);
        int count = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; j++) {
                long sum = treeArray.prefixSum(j + 1) - treeArray.prefixSum(i);
                if (sum >= lower && sum <= upper) {
                    ++count;
                }
            }
        }
        return count;
    }

    private static int countRangeSumPro(int[] nums, int lower, int upper) {
        int n = nums.length, len = 4 * n;
        Segment[] segmentTree = new Segment[len + 10];
        buildSegmentTree(segmentTree, nums, 0, n - 1, 1);
        int count = 0;
        for (int i = 0; i < len; ++i) {
            if (segmentTree[i] == null) {
                continue;
            }
            if (segmentTree[i].sum >= lower && segmentTree[i].sum <= upper) {
                ++count;
            }
        }
        return count;
    }

    static class Segment {
        /**
         * 线段树节点的区间和
         */
        final long sum;

        /**
         * 是否存在元素值
         */
        final boolean existValue;

        public Segment(long sum, boolean existValue) {
            this.sum = sum;
            this.existValue = existValue;
        }
    }

    /**
     * 递归构建线段树
     *
     * @param segmentTree 线段树
     * @param nums        原始数组
     * @param l           左边界
     * @param r           右边界
     * @param position    当前位置
     */
    private static void buildSegmentTree(Segment[] segmentTree,
                                         int[] nums,
                                         int l,
                                         int r,
                                         int position) {
        if (l == r) {
            segmentTree[position] = new Segment(nums[l], true);
        } else {
            int mid = l + ((r - l) >> 1);
            buildSegmentTree(segmentTree, nums, l, mid, position << 1);
            buildSegmentTree(segmentTree, nums, mid + 1, r, (position << 1) | 1);
            segmentTree[position] = new Segment(segmentTree[position << 1].sum + segmentTree[(position << 1) | 1].sum, true);
        }
    }

    /**
     * 计算区间和的个数
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n)
     * 超时
     */
    private static int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int count = 0;
        for (int i = 0; i <= n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                long diff = preSum[j] - preSum[i];
                if (diff >= lower && diff <= upper) {
                    count++;
                }
            }
        }
        return count;
    }
}
