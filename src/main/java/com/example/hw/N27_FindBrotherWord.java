package com.example.hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author zhenwu
 */
public class N27_FindBrotherWord {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] strArray = line.split(" ");

        int wordCount = Integer.parseInt(strArray[0]);
        String[] words = new String[wordCount];
        System.arraycopy(strArray, 1, words, 0, wordCount);

        int len = strArray.length;
        String target = strArray[len - 2];
        int location = Integer.parseInt(strArray[len - 1]);

        List<String> brotherWordList = new ArrayList<>();
        for (String word : words) {
            if (isBrotherWord(word, target)) {
                brotherWordList.add(word);
            }
        }

        String[] brotherWordArray = new String[brotherWordList.size()];
        for (int i = 0; i < brotherWordList.size(); i++) {
            brotherWordArray[i] = brotherWordList.get(i);
        }
        Arrays.sort(brotherWordArray);

        System.out.println(brotherWordArray.length);
        if (location <= brotherWordArray.length) {
            System.out.println(brotherWordArray[location - 1]);
        }
    }

    private static boolean isBrotherWord(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        if (word1.equals(word2)) {
            return false;
        }
        char[] charArray1 = word1.toCharArray();
        char[] charArray2 = word2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return new String(charArray1).equals(new String(charArray2));
    }
}
