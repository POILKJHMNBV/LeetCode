package com.example.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenwu
 */
public class L679_JudgePoint24 {
    public static void main(String[] args) {
        int[] cards = {4, 1, 8, 7};
        System.out.println(judgePoint24(cards));
    }

    private static boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int num : cards) {
            list.add((double) num);
        }
        return resolve(list);
    }

    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

    private static boolean resolve(List<Double> list) {
        int size = list.size();
        if (size == 0) {
            return false;
        }
        if (size == 1) {
            // 算完所剩的最后一个数即为结果
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }
        for (int i = 0; i < size; i++) {
            // 从list中挑一个数
            for (int j = 0; j < size; j++) {
                // 从list中再挑一个数
                if (i != j) {
                    // 不能挑一样的数
                    // 没被挑到的数放入list2, 进入下一轮计算
                    List<Double> list2 = new ArrayList<>();
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            list2.add(list.get(k));
                        }
                    }

                    for (int k = 0; k < 4; k++) {
                        // 从四种运算符中挑一个对前面选中的两个数进行运算
                        if (k < 2 && i > j) {
                            // k < 2是指，所挑运算为加或乘
                            // i > j是为了判定交换律的成立，如果i < j,说明是第一次做加或乘运算
                            // eg: i = 0, j = 1, k = 1 → 挑第一个和第二个数，两数相乘
                            //    i = 1, j = 0, k = 1 → 挑第二个和第一个数，两数相乘  →  无效的重复计算
                            continue;
                        }
                        if (k == ADD) {
                            // 将计算结果放入list2, 用于下一轮运算
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == SUBTRACT) {
                            list2.add(list.get(i) - list.get(j));
                        } else {
                            if (list.get(j) < EPSILON) {
                                // 除数为0, 跳出本次循环
                                continue;
                            } else {
                                list2.add(list.get(i) / list.get(j));
                            }
                        }
                        if (resolve(list2)) {
                            return true;
                        }

                        // 本次运算为凑成24, 回溯, 进行下一轮运算
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }
}
