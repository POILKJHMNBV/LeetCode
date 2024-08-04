package com.example.hw;

import java.util.Scanner;

/**
 * 识别有效的IP地址和掩码并进行分类统计
 *
 */
public class N18_IpClassify {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] res = new int[7];
        while(in.hasNextLine()) {
            String line = in.nextLine();
            String[] strs = line.split("~");
            String ip = strs[0], mask = strs[1];
            if(errorIpOrMask(ip) || errorIpOrMask(mask) || !legalMask(mask)) {
                res[5]++;
            } else if(legalIp(ip)) {
                String[] numsArray = ip.split("\\.");
                int a = Integer.parseInt(numsArray[0]);
                int b = Integer.parseInt(numsArray[1]);
                int c = Integer.parseInt(numsArray[2]);
                int d = Integer.parseInt(numsArray[3]);
                if(aIp(a, b, c, d)) {
                    res[0]++;
                    if(privateIp(a, b, c, d)) {
                        res[6]++;
                    }
                } else if(bIp(a, b, c, d)) {
                    res[1]++;
                    if(privateIp(a, b, c, d)) {
                        res[6]++;
                    }
                } else if(cIp(a, b, c, d)) {
                    res[2]++;
                    if(privateIp(a, b, c, d)) {
                        res[6]++;
                    }
                } else if(dIp(a, b, c, d)) {
                    res[3]++;
                } else if(eIp(a, b, c, d)) {
                    res[4]++;
                }
            }

            for(int num : res) {
                System.out.print(num + " ");
            }
            System.out.println("-----------");
        }
        /*for(int num : res) {
            System.out.print(num + " ");
        }*/
    }

    private static boolean aIp(int a, int b, int c, int d) {
        return (a >= 1 && a <= 126)
                && (b >= 0 && b <= 255)
                && (c >= 0 && c <= 255)
                && (d >= 0 && d <= 255);
    }

    private static boolean bIp(int a, int b, int c, int d) {
        return (a >= 128 && a <= 191)
                && (b >= 0 && b <= 255)
                && (c >= 0 && c <= 255)
                && (d >= 0 && d <= 255);
    }

    private static boolean cIp(int a, int b, int c, int d) {
        return (a >= 192 && a <= 223)
                && (b >= 0 && b <= 255)
                && (c >= 0 && c <= 255)
                && (d >= 0 && d <= 255);
    }

    private static boolean dIp(int a, int b, int c, int d) {
        return (a >= 224 && a <= 239)
                && (b >= 0 && b <= 255)
                && (c >= 0 && c <= 255)
                && (d >= 0 && d <= 255);
    }

    private static boolean eIp(int a, int b, int c, int d) {
        return (a >= 240 && a <= 255)
                && (b >= 0 && b <= 255)
                && (c >= 0 && c <= 255)
                && (d >= 0 && d <= 255);
    }

    private static boolean privateIp(int a, int b, int c, int d) {
        return (a == 10 && (b >= 0 && b <= 255) && (c >= 0 && c <= 255) && (d >= 0 && d <= 255))
                || (a == 172 && (b >= 16 && b <= 31) && (c >= 0 && c <= 255) && (d >= 0 && d <= 255))
                || (a == 192 && (b == 168) && (c >= 0 && c <= 255) && (d >= 0 && d <= 255));
    }

    private static boolean legalMask(String mask) {
        String[] strs = mask.split("\\.");
        if(strs.length != 4) {
            return false;
        }
        int a = Integer.parseInt(strs[0]);
        int b = Integer.parseInt(strs[1]);
        int c = Integer.parseInt(strs[2]);
        int d = Integer.parseInt(strs[3]);
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toBinaryString(a))
                .append(Integer.toBinaryString(b))
                .append(Integer.toBinaryString(c))
                .append(Integer.toBinaryString(d));
        char[] charArray = sb.toString().toCharArray();
        if (charArray[0] == '0') {
            return false;
        }
        char pre = '1';
        for(char ch : charArray) {
            if(ch == '1' && pre == '0') {
                return false;
            }
            pre = ch;
        }
        if(charArray[charArray.length - 1] == '1'){
            return false;
        }
        return true;
    }

    private static boolean errorIpOrMask(String ipOrMask) {
        String[] strs = ipOrMask.split("\\.");
        if(strs.length != 4) {
            return false;
        }
        if (strs[0].isEmpty()
                || strs[1].isEmpty()
                || strs[2].isEmpty()
                || strs[3].isEmpty()) {
            return true;
        }
        if(strs[0] == "0" && strs[1] == "0" && strs[2] == "0" && strs[3] == "0") {
            return true;
        }
        return false;
    }

    private static boolean legalIp(String ip) {
        String[] strs = ip.split("\\.");
        if(strs.length != 4) {
            return false;
        }
        if(!legalNum(strs[0])
                || !legalNum(strs[1])
                || !legalNum(strs[2])
                || !legalNum(strs[3])) {
            return false;
        }
        if(legalNum(strs[0]) && Integer.parseInt(strs[0]) == 0) {
            return false;
        }
        return true;
    }

    private static boolean legalNum(String numStr) {
        try {
            int num = Integer.parseInt(numStr);
            return num >= 0 && num <= 255;
        } catch(Exception e) {
            return false;
        }
    }
}
