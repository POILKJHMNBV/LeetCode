package com.example.array;

import com.example.stack.L84_LargestRectangleArea;

/**
 * <p>L85:最大矩形</p>
 * @author zhenwu
 * @date 2024/10/5 21:55
 */
public class L85_MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '1', '1'},
                {'1', '0', '1', '0', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '0', '1', '1'}
        };
        System.out.println(maximalRectangle(matrix));
    }

    /**
     * 求最大矩形
     * 时间：O(mn)  空间：O(n)
     */
    private static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        // Step 1: Preprocess the height map
        for (char[] chars : matrix) {
            for (int j = 0; j < cols; j++) {
                if (chars[j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            // Step 2: Use stack to find max rectangle for this height map
            maxArea = Math.max(maxArea, L84_LargestRectangleArea.largestRectangleArea(heights));
        }

        return maxArea;
    }
}
