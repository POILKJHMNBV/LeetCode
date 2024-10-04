package com.example.string;

/**
 * <p>L67:二进制求和</p>
 * @author zhenwu
 * @date 2024/10/4 9:29
 */
public class L67_AddBinary {
    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(addBinary(a, b));
    }

    /**
     * 时间：O(n)  空间：O(1)
     */
    private static String addBinary(String a, String b) {
        char[] charA = a.toCharArray(), charB = b.toCharArray();
        int lenA = charA.length, lenB = charB.length;
        StringBuilder ans = new StringBuilder();
        int carry = 0, i = lenA -1, j = lenB - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            int sum = (charA[i] - '0') + (charB[j] - '0') + carry;
            ans.append(sum % 2);
            carry = sum / 2;
        }
        for (; i >= 0; i--) {
            int sum = (charA[i] - '0') + carry;
            ans.append(sum % 2);
            carry = sum / 2;
        }
        for (; j >= 0; j--) {
            int sum = (charB[j] - '0') + carry;
            ans.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) {
            ans.append(1);
        }
        return ans.reverse().toString();
    }
}
