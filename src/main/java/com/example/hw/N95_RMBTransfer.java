package com.example.hw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author zhenwu
 * 2024/6/22 20:43
 */
public class N95_RMBTransfer {

    private static final char[] CHINESE_ARRAY = {'a', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖'};
    private static final Map<Integer, Character> CHINESE_INTEGER_MAP;
    static {
        CHINESE_INTEGER_MAP = new HashMap<>();
        CHINESE_INTEGER_MAP.put(2, '拾');
        CHINESE_INTEGER_MAP.put(3, '佰');
        CHINESE_INTEGER_MAP.put(4, '仟');
        CHINESE_INTEGER_MAP.put(5, '万');
        CHINESE_INTEGER_MAP.put(9, '亿');
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strArray = in.nextLine().split("\\.");
        System.out.println("人民币" + getIntPartChinese(strArray[0]) + getDecimalChinese(strArray[1]));
    }

    private static String getDecimalChinese(String decimalPart) {
        char[] chars = decimalPart.toCharArray();
        StringBuilder sb = new StringBuilder();
        if (chars[0] == '0' && chars[1] == '0') {
            return "整";
        } else {
           if (chars[0] != '0') {
               sb.append(CHINESE_ARRAY[chars[0] - '0']).append('角');
           }
           if (chars[1] != '0') {
               sb.append(CHINESE_ARRAY[chars[1] - '0']).append('分');
           }
        }
        return sb.toString();
    }

    private static String getIntPartChinese(String intPart) {
        int len = intPart.length();
        StringBuilder res = new StringBuilder();
        if (len <= 2) {
            processOneOrTwo(Integer.parseInt(intPart), res);
        } else if (len == 3) {
            processThree(Integer.parseInt(intPart), res);
        } else if (len == 4) {
            processFour(Integer.parseInt(intPart), res);
        } else if (len <= 8) {
            processFiveToEight(Integer.parseInt(intPart), res);
        } else {
            processNineToTwelve(Long.parseLong(intPart), res);
        }
        if (res.length() != 0) {
            res.append('元');
        }
        return res.toString();
    }

    private static void processNineToTwelve(long num, StringBuilder res) {
        char oneHundredMillionCh = CHINESE_INTEGER_MAP.get(9);
        int oneHundredMillion = (int) Math.pow(10, 9);
        int highOrder = (int) (num / Math.pow(10, 9));
        if (highOrder < 10) {
            res.append(CHINESE_ARRAY[highOrder]);
        } else if (highOrder < 99) {
            processOneOrTwo(highOrder, res);
        } else if (highOrder < 999) {
            processThree(highOrder, res);
        } else if (highOrder < 9999) {
            processFour(highOrder, res);
        }
        res.append(oneHundredMillionCh);
        if (num % oneHundredMillion == 0) {
            return;
        }
        int lowOrder = (int) (num % (highOrder * oneHundredMillion));
        if (lowOrder < 10000000) {
            res.append('零');
            if (lowOrder < 100) {
                processOneOrTwo(lowOrder, res);
            } else if (lowOrder < 9999){
                processThree(lowOrder, res);
            } else {
                processFiveToEight(lowOrder, res);
            }
        } else {
            processFiveToEight(lowOrder, res);
        }
    }

    private static void processFiveToEight(int num, StringBuilder res) {
        char tenThousand = CHINESE_INTEGER_MAP.get(5);
        int highOrder = num / 10000;
        if (highOrder < 10) {
            res.append(CHINESE_ARRAY[highOrder]);
        } else if (highOrder < 99) {
            processOneOrTwo(highOrder, res);
        } else if (highOrder < 999) {
            processThree(highOrder, res);
        } else if (highOrder < 9999) {
            processFour(highOrder, res);
        }
        res.append(tenThousand);
        if (num % 10000 == 0) {
            return;
        }
        int lowOrder = num % (highOrder * 10000);
        if (lowOrder < 1000) {
            res.append('零');
            if (lowOrder < 100) {
                processOneOrTwo(lowOrder, res);
            } else {
                processThree(lowOrder, res);
            }
        } else {
            processFour(lowOrder, res);
        }
    }

    private static void processFour(int num, StringBuilder res) {
        char thousand = CHINESE_INTEGER_MAP.get(4);
        int highOrder = num / 1000;
        res.append(CHINESE_ARRAY[highOrder]).append(thousand);
        if (num % 1000 == 0) {
            return;
        }
        int lowOrder = num % (highOrder * 1000);
        if (lowOrder < 100) {
            res.append('零');
            processOneOrTwo(lowOrder, res);
        } else {
            processThree(lowOrder, res);
        }
    }

    private static void processThree(int num, StringBuilder res) {
        char hundred = CHINESE_INTEGER_MAP.get(3);
        int highOrder = num / 100;
        res.append(CHINESE_ARRAY[highOrder]).append(hundred);
        if (num % 100 == 0) {
            return;
        }
        int lowOrder = num % (highOrder * 100);
        if (lowOrder < 10) {
            res.append('零');
        }
        processOneOrTwo(lowOrder, res);
    }

    private static void processOneOrTwo(int num, StringBuilder res) {
        if (num < 10 && num != 0) {
            res.append(CHINESE_ARRAY[num]);
        } else if (num >= 10) {
            char ten = CHINESE_INTEGER_MAP.get(2);
            if (num % 10 == 0) {
                res.append(ten);
            } else if (num / 10 == 1) {
                res.append(ten).append(CHINESE_ARRAY[num % 10]);
            } else {
                res.append(CHINESE_ARRAY[num / 10]).append(ten).append(CHINESE_ARRAY[num % 10]);
            }
        }
    }
}
