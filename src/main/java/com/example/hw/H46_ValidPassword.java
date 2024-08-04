package com.example.hw;

import java.util.Scanner;

/**
 * <p>密码输入检测</p>
 * <p>
 *     给定用户密码输入流input，输入流中字符 '<' 表示退格，可以清除前一个输入的字符，请你编写程序，输出最终得到的密码字符，并判断密码是否满足如下的密码安全要求。
 *     密码安全要求如下:
 *          1.密码长度>=8;
 *          2.密码至少需要包含1个大写字母:
 *          3.密码至少需要包含1个小写字母;
 *          4.密码至少需要包含1个数字;
 *          5.密码至少需要包含1个字母和数字以外的非空白特殊字符;
 *     注意空串退格后仍然为空串，且用户输入的字符串不包含 '<' 字符和空白字符。
 * </p>
 * <p>
 *     输入描述：用一行字符串表示输入的用户数据，输入的字符串中 '<' 字符标识退格，用户输入的字符串不包含空白字符，例如:ABC<c89%000<
 * </p>
 * <p>
 *     输出描述：输出经过程序处理后，输出的实际密码字符串，并输出该密码字符串是否满足密码安全要求。两者间由 ',' 分隔，例如:ABc89%00,true
 * </p>
 * @author zhenwu
 * @date 2024/7/14 15:37
 */
public class H46_ValidPassword {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (ch == '<') {
                sb.deleteCharAt(sb.length() - 1);
                continue;
            }
            sb.append(ch);
        }
        String password = sb.toString();
        System.out.println(password + "," + validPassword(password));
    }

    private static boolean validPassword(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean containsUpperChar = false;
        boolean containsLowerChar = false;
        boolean containsDigit = false;
        boolean containsOtherChar = false;
        for (char ch : password.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                containsUpperChar = true;
            } else if (ch >= 'a' && ch <= 'z') {
                containsLowerChar = true;
            } else if (Character.isDigit(ch)) {
                containsDigit = true;
            } else {
                containsOtherChar = true;
            }
        }
        return containsUpperChar && containsLowerChar&& containsDigit && containsOtherChar;
    }
}
