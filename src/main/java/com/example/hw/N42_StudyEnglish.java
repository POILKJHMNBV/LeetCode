package com.example.hw;

import java.util.*;

/**
 * @author zhenwu
 */
public class N42_StudyEnglish {
    private static final String[] words = {"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","twenty"};

    private static final String[] wordArray = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long num = in.nextLong();
        if (num <= 20) {
            System.out.println(words[(int)(num - 1)]);
            return;
        }
        if (num < 100) {
            int first = (int)(num / 10);
            int second =  (int)(num % 10);
            if (second == 0) {
                System.out.println(wordArray[first - 2]);
                return;
            }
            System.out.println(wordArray[first - 2] + " " + words[second - 1]);
        }
        String s = String.valueOf(num);
        Deque<String> stack = new ArrayDeque<>();
        if (s.length() == 3) {
            processThreeNum((int)num, stack);
        } else if (s.length() == 4 || s.length() == 5) {
            processFourOrFiveNum((int)num, stack);
        } else if (s.length() == 6) {
            processSixNum((int)num, stack);
        } else if (s.length() == 7) {
            processSevenNum((int)num, stack);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            String str = stack.pop();
            sb.append(str).append(" ");
            if ("hundred".equals(str) && !stack.isEmpty()) {
                sb.append("and ");
            }
        }
        System.out.println(sb);
    }

    private static void processSevenNum(int num, Deque<String> stack) {
        int a = num % 1000000;
        if (a != 0) {
            if (a >= 100000) {
                processSixNum(a, stack);
            } else {
                processFourOrFiveNum(a, stack);
            }
        }
        stack.push("million");
        stack.push(words[num / 1000000- 1]);
    }

    private static void processSixNum(int num, Deque<String> stack) {
        int a = num % 1000;
        if (a != 0) {
            if (a >= 100) {
                processThreeNum(a, stack);
            } else {
                processOneOrTwoNum(a, stack);
            }
        }
        stack.push("thousand");
        processThreeNum(num / 1000, stack);
    }

    private static void processFourOrFiveNum(int num, Deque<String> stack) {
        int a = num % 1000;
        if (a != 0) {
            if (a >= 100) {
                processThreeNum(a, stack);
            } else {
                processOneOrTwoNum(a, stack);
            }
        }
        stack.push("thousand");
        processOneOrTwoNum(num / 1000, stack);
    }

    private static void processThreeNum(int num, Deque<String> stack) {
        int a = num % 100;
        if (a != 0) {
            processOneOrTwoNum(a, stack);
        }
        stack.push("hundred");
        stack.push(words[(num / 100) - 1]);
    }

    private static void processOneOrTwoNum(int num, Deque<String> stack) {
        if (num <= 20) {
            stack.push(words[num - 1]);
        } else if (num % 10 == 0) {
            stack.push(wordArray[(num / 10) - 2]);
        } else {
            stack.push(words[(num % 10) - 1]);
            stack.push(wordArray[(num / 10) - 2]);
        }
    }
}
