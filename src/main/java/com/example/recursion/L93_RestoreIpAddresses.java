package com.example.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L93:复原 IP 地址</p>
 * <p>有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案</p>
 */
public class L93_RestoreIpAddresses {
    public static void main(String[] args) {
        String s = "101023";
        System.out.println(restoreIpAddressesPlus(s));
    }

    private static List<String> restoreIpAddressesPlus(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.isEmpty() || !s.matches("\\d+")) {
            return res;
        }
        backTracking(s, res, "", 0, 0);
        return res;
    }

    private static void backTracking(String s, List<String> res, String ip, int pointSum, int startIndex) {
        if (pointSum == 3) {
            String substring = s.substring(startIndex);
            if (isValid(substring)) {
                res.add(ip + substring);
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String substring = s.substring(startIndex, i + 1);
            if (isValid(substring)) {
                backTracking(s, res, ip + substring + ".", pointSum + 1, i + 1);
            }
        }
    }

    private static boolean isValid(String s) {
        if ("0".equals(s)) {
            return true;
        }
        return !s.isEmpty() && !s.startsWith("0") && s.length() < 4 && Integer.parseInt(s) <= 255;
    }

    private static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.isEmpty() || !s.matches("\\d+")) {
            return res;
        }
        process(s, res, "", 0);
        return res;
    }

    private static void process(String s, List<String> res, String ip, int startIndex) {
        if (startIndex == s.length()) {
            if (validIpAddress(ip.substring(0, ip.length() - 1))) {
                res.add(ip.substring(0, ip.length() - 1));
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String s1 = s.substring(startIndex, i + 1);
            if (s1.length() > 3 || Integer.parseInt(s1) > 255){
                continue;
            }
            process(s, res, ip + s1 + ".", i + 1);
        }
    }

    private static boolean validIpAddress(String ip) {
        try {
            String[] strings = ip.split("\\.");
            if (strings.length != 4){
                return false;
            }
            for (String s : strings) {
                if (s.length() > 1 && s.startsWith("0")) {
                    return false;
                }
                int num = Integer.parseInt(s);
                if (num > 255) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
