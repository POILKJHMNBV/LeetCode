package com.example.hw;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * <p>英文输入法</p>
 * <p>
 *     主管期望你来实现英文输入法单词联想功能。需求如下:
 *     依据用户输入的单词前缀，从已输入的英文语句中联想出用户想输入的单词，按字典序输出联想到的单词序列，如果联想不到，请输出用户输入的单词前缀。
 *     注意：
 *          1.英文单词联想时，区分大小写
 *          2.缩略形式如"don’t”，判定为两个单词，"don“和"t“
 *          3.输出的单词序列，不能有重复单词，且只能是英文单词，不能有标点符号
 * </p>
 * <p>
 *     输入描述：
 *          输入为两行，首行输入一段由英文单词word和标点符号组成的语句str；接下来一行为一个英文单词前缀pre
 *          0 < word.length() ⩽ 20
 *          0 < str.length() ⩽ 1000
 *          0 < pre ⩽ 20
 * </p>
 * <p>
 *     输出描述：输出符合要求的单词序列或单词前缀，存在多个时，单词之间以单个空格分割；
 * </p>
 * @author zhenwu
 * @date 2024/7/21 14:39
 */
public class H82_EnglishInputMethod {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();
        String pre = in.nextLine();

        Set<String> words = new HashSet<>();
        StringBuilder tmpStr = new StringBuilder();
        for (char ch : chars) {
            if (Character.isLetter(ch)) {
                tmpStr.append(ch);
            } else if (tmpStr.length() > 0) {
                words.add(tmpStr.toString());
                tmpStr.setLength(0);
            }
        }
        if (tmpStr.length() > 0) {
            words.add(tmpStr.toString());
        }

        for (String word : words) {
            if (word.startsWith(pre)) {
                System.out.print(word + " ");
            }
        }
    }
}
