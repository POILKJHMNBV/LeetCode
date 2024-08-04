package com.example.hw;

import java.util.Scanner;

/**
 * @author zhenwu
 * 255.255.255.0
 * 192.168.224.256
 * 192.168.10.4
 * 255.0.0.0
 * 193.194.202.15
 * 232.43.7.59
 * 255.255.255.0
 * 192.168.0.254
 * 192.168.0.1
 */
public class N39_InSameSubNetwork {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mask = sc.nextLine();
        String ip1 = sc.nextLine();
        String ip2 = sc.nextLine();
        String maskBinaryString = isValidMask(mask);
        String ip1BinaryString = isValidIp(ip1);
        String ip2BinaryString = isValidIp(ip2);
        if (maskBinaryString == null || ip1BinaryString == null || ip2BinaryString == null) {
            System.out.println(1);
            return;
        }
        if (isSameSubNetwork(maskBinaryString, ip1BinaryString, ip2BinaryString)) {
            System.out.println(0);
        } else {
            System.out.println(2);
        }
    }

    private static boolean isSameSubNetwork(String mask, String ip1, String ip2) {
        char[] maskCharArray = mask.toCharArray();
        char[] ip1CharArray = ip1.toCharArray();
        char[] ip2CharArray = ip2.toCharArray();
        int len = maskCharArray.length;
        for (int i = 0; i < len; i++) {
            if (maskCharArray[i] == '0') {
                break;
            }
            if (ip1CharArray[i] != ip2CharArray[i]) {
                return false;
            }
        }
        return true;
    }

    private static String isValidIp(String ip) {
        for (String s : ip.split("\\.")) {
            int num = Integer.parseInt(s);
            if (num < 0 || num > 255) {
                return null;
            }
        }
        return transToBinaryString(ip);
    }

    private static String isValidMask(String mask) {
        for (String s : mask.split("\\.")) {
            int num = Integer.parseInt(s);
            if (num < 0 || num > 255) {
                return null;
            }
        }
        String binaryString = transToBinaryString(mask);
        for (int i = 0; i < binaryString.length() - 1; i++) {
            if (binaryString.charAt(i) == '0' && binaryString.charAt(i + 1) == '1') {
                return null;
            }
        }
        return binaryString;
    }

    private static String transToBinaryString(String ip) {
        String[] strArray = ip.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String s : strArray) {
            int num = Integer.parseInt(s);
            String binaryString = "00000000" + Integer.toBinaryString(num);
            sb.append(binaryString.substring(binaryString.length() - 8));
        }
        return sb.toString();
    }
}
