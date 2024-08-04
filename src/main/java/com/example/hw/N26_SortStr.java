package com.example.hw;

import java.util.Scanner;

/**
 * @author zhenwu
 */
public class N26_SortStr {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] charArray = str.toCharArray();
        int len = charArray.length;
        for (int i = 1; i < len; i++) {
            if (!isCharacter(charArray[i])) {
                continue;
            }
            int index = i;
            for (int j = i; j > 0; j--) {
                if (isCharacter(charArray[j - 1])
                        && isCharacter(charArray[index])
                        && isSmall(charArray[index], charArray[j - 1])) {
                    swap(charArray, j - 1, index);
                    index = j - 1;
                }
            }
        }
        for (char ch : charArray) {
            System.out.print(ch);
        }
    }

    public static boolean isCharacter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    public static boolean isUpperCharacter(char ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public static boolean isSmall(char a, char b) {
        if (isUpperCharacter(a)) {
            a = (char) (a + 32);
        }
        if (isUpperCharacter(b)) {
            b = (char) (b + 32);
        }
        return a < b;
    }

    public static void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}
