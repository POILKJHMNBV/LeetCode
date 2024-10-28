package com.example.array;

/**
 * <p>L201:数字范围按位与</p>
 * @author zhenwu
 * @date 2024/10/28 21:23
 */
public class L201_RangeBitwiseAnd {
    public static void main(String[] args) {
        int left = 1073741824, right = Integer.MAX_VALUE;
        System.out.println(rangeBitwiseAnd(left, right));
    }

    /**
     * 数字范围按位与
     * 时间复杂度：O(n), 其中 n = right - left + 1
     * 空间复杂度：O(1)
     */
    private static int rangeBitwiseAnd(int left, int right) {
        int res = left & right;
        while (left < right) {
            left++;
            res &= left;
            if (res == 0) {
                return 0;
            }
        }
        return res;
    }

    /**
     * 数字范围按位与
     * 时间复杂度：O(log(right))
     * 空间复杂度：O(1)
     */
    private static int rangeBitwiseAndPro(int left, int right) {
        int shift = 0;
        // 找到 left 和 right 的最高不同位
        while (left < right) {
            left >>= 1; // 左移 left
            right >>= 1; // 左移 right
            shift++; // 记录移动的位数
        }
        // 将 left（或 right，此时它们相等）右移回原来的位置，但将变化位及之后的所有位设置为 0
        return left << shift;
    }
}
