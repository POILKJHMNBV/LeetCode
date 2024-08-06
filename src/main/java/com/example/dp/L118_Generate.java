package com.example.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>L118:杨辉三角</p>
 * <p>
 *     给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *     在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * </p>
 * @author zhenwu
 * @date 2024/8/6 20:45
 */
public class L118_Generate {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));
    }

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> listA = List.of(1);
        res.add(listA);
        if (numRows == 1) {
            return res;
        }
        for (int i = 2; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                int a = j - 1 >= 0 && j - 1 < listA.size() ? listA.get(j - 1) : 0;
                int b = j < listA.size() ? listA.get(j) : 0;
                list.add(a + b);
            }
            res.add(list);
            listA = list;
        }
        return res;
    }
}
