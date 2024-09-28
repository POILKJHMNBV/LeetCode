package com.example.string;

/**
 * <p>L43:字符串相乘</p>
 * @author zhenwu
 * @date 2024/9/28 21:10
 */
public class L43_Multiply {
    public static void main(String[] args) {
        String num1 = "23", num2 = "56";
        System.out.println(multiply(num1, num2));
    }

    /**
     * 时间：O(m * n)      空间：O(m + n)
     */
    private static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length(), n = num2.length();
        int[] result = new int[m + n]; // 初始化结果数组，长度为两个输入字符串长度之和

        // 逐位相乘
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                int sum = x * y + result[i + j + 1]; // 加上之前进位的值
                result[i + j + 1] = sum % 10; // 更新当前位置的余数
                result[i + j] += sum / 10; // 更新进位
            }
        }

        // 将结果数组转换为字符串
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true; // 用于跳过前导零
        for (int num : result) {
            if (!leadingZero || num != 0) {
                sb.append(num);
                leadingZero = false;
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
