package com.example.hw;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhenwu
 */
public class N20_ValidPassword {
    public static void main(String[] args) {
        String password = "021$bc9000";
        System.out.println(validPassword(password));
    }

    public static boolean containsRepeatSubstring(String s) {
        if (s == null || s.length() < 3) {
            return false;
        }

        // 从长度为3的子串开始检查，因为要求长度大于2
        for (int len = 3; len <= s.length() / 2; len++) { // 只需要检查到字符串长度的一半
            Set<String> seen = new HashSet<>();
            for (int i = 0; i <= s.length() - len; i++) {
                String substring = s.substring(i, i + len);
                if (seen.contains(substring)) {
                    return true; // 找到重复子串，返回它
                }
                seen.add(substring);
            }
        }
        return false;
    }


    public static boolean validPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        if (containsRepeatSubstring(password)) {
            return false;
        }

        if (containsDigit(password) && containsUpperChar(password) && containsLowerChar(password)) {
            return true;
        } else if (containsDigit(password) && containsUpperChar(password) && containsOtherChar(password)) {
            return true;
        } else if (containsDigit(password) && containsLowerChar(password) && containsOtherChar(password)) {
            return true;
        } else {
            return containsUpperChar(password) && containsLowerChar(password) && containsOtherChar(password);
        }
    }

    public static boolean containsDigit(String password) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public static boolean containsUpperChar(String password) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public static boolean containsLowerChar(String password) {
        Pattern pattern = Pattern.compile("[a-z]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }

    public static boolean containsOtherChar(String password) {
        Pattern pattern = Pattern.compile("[^\\n\\dA-Za-z]");
        Matcher matcher = pattern.matcher(password);
        return matcher.find();
    }
}
