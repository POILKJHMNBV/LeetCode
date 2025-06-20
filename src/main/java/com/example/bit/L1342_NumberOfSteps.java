package com.example.bit;

/**
 * <p>L1342:转换数字的最少位翻转次数</p>
 * @author zhenwu
 * @date 2025/6/20 21:15
 */
public class L1342_NumberOfSteps {
    public static void main(String[] args) {

    }

    /**
     * 时间复杂度: O(log num)
     * 空间复杂度: O(1)
     */
    private static int numberOfSteps(int num) {
        int ans = 0;
        while (num != 0) {
            if (num % 2 == 1) {
                num--;
            } else {
                num /= 2;
            }
            ans++;
        }
        return ans;
    }
}
