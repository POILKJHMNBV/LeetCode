package com.example.recursion;

/**
 * <p>L306:累加数</p>
 * @author zhenwu
 * @date 2024/12/2 21:46
 */
public class L306_IsAdditiveNumber {
    public static void main(String[] args) {

    }

    private static boolean isAdditiveNumber(String num) {
        // 如果字符串长度小于3，则不可能形成累加序列
        if (num.length() < 3) return false;

        // 尝试所有可能的第一个和第二个数字的组合
        for (int i = 1; i <= num.length() / 2; i++) {
            for (int j = 1; j <= (num.length() - i) / 2; j++) {
                // 获取第一个数字
                String first = num.substring(0, i);
                // 获取第二个数字
                String second = num.substring(i, i + j);

                // 检查是否有前导零
                if ((first.length() > 1 && first.charAt(0) == '0') ||
                        (second.length() > 1 && second.charAt(0) == '0')) {
                    continue;
                }

                // 从第三个位置开始检查剩余的字符串是否符合累加序列
                if (isValid(num, i + j, first, second)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(String num, int start, String first, String second) {
        // 如果已经到达字符串末尾，说明之前的组合是有效的累加序列
        if (start == num.length()) return true;

        // 计算下一个数字
        String sum = addStrings(first, second);

        // 检查剩余的字符串是否以计算出的sum开头
        if (!num.startsWith(sum, start)) {
            return false;
        }

        // 递归检查下一个部分
        return isValid(num, start + sum.length(), second, sum);
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        // 从右向左逐位相加
        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int digit2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }

        // 结果需要反转
        return sb.reverse().toString();
    }
}