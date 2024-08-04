package com.example.hw;

import java.util.Scanner;

/**
 * @author zhenwu
 * 83
 * UUDU DDDD UDUU DDDD UDD
 */
public class N64_CursorLocation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int musics = in.nextInt();
        char[] operateArray = in.next().toCharArray();
        int point = 1, curMusic = 1;
        for (char operate : operateArray) {
            if (operate == 'D') {
                curMusic++;
                if (curMusic > musics) {
                    curMusic = 1;
                    point = 1;
                } else {
                    point++;
                    if (point > 4) {
                        point = 4;
                    }
                }
            } else {
                curMusic--;
                if (curMusic < 1) {
                    curMusic = musics;
                    point = 4;
                } else {
                    point--;
                    if (point < 1) {
                        point = 1;
                    }
                }
            }
        }
        if (point == 1) {
            System.out.println(curMusic + " " + (curMusic + 1) + " " + (curMusic + 2) + " " + (curMusic + 3));
        } else if (point == 2) {
            System.out.println((curMusic - 1) + " " + curMusic + " " + (curMusic + 1) + " " + (curMusic + 2));
        } else if (point == 3) {
            System.out.println((curMusic - 2) + " " + (curMusic - 1) + " " + curMusic + " " + (curMusic + 1));
        } else {
            System.out.println((curMusic - 3) + " " + (curMusic - 2) + " " + (curMusic - 1) + " " + curMusic);
        }
        System.out.println(curMusic);
    }
}
