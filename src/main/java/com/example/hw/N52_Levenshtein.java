package com.example.hw;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhenwu
 */
public class N52_Levenshtein {
    public static void main(String[] args) {
        char[] arr1 = "ucyfsmg".toCharArray();
        char[] arr2 = "zuixhuhyjgksyhqkjqxwylkoubykjxtcvkyqjpzgltbemmbmqibxxqpkgbvwbmjotixanvciibubglizmumcrjavakiygyuv".toCharArray();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPerfectNumber(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean isPerfectNumber(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        return sum == n;
    }
}
