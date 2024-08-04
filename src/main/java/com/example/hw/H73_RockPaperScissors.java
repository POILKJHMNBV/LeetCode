package com.example.hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * <p>石头剪刀布游戏</p>
 * <p>
 *      石头剪刀布游戏有 3 种出拳形状: 石头、剪刀、布。分别用字母 A,B,C 表示游戏规则：
 *          1.出拳形状之间的胜负规则如下: A>B; B>C; C>A； 左边一个字母，表示相对优势形状。右边一个字母，表示相对劣势形状。
 *          2.当本场次中有且仅有一种出拳形状优于其它出拳形状，则该形状的玩家是胜利者。否则认为是平局。当发生平局，没有赢家。有多个胜利者时，同为赢家。
 *      例如 1: 三个玩家出拳分别是A,B,C，由于出现三方优势循环(即没有任何一方优于其它出拳者)，判断为平局。
 *      例如 2: 两个玩家，出拳分别是 A，B，出拳 A的获胜。
 *      例如 3: 三个玩家，出拳全部是 A，判为平局。
 * </p>
 * <p>
 *     输入描述：
 *          在一场游戏中，每个玩家的信息为一行。玩家数量不超过 1000
 *          每个玩家信息有 2 个字段，用空格隔开：
 *              1.玩家 ID:一个仅由 英文字母Q和数字组成的字符串。
 *              2.出拳形状: 以英文大写字母表示，A、B、C 形状。
 * </p>
 * <p>
 *     输出描述：
 *          输出为赢家的玩家 ID 列表(一个或多个)，每个 ID 一行，按字符串升序排列。
 *          如果没有赢家，输出为“NULL"字符串。
 * </p>
 * @author zhenwu
 * @date 2024/7/20 14:25
 */
public class H73_RockPaperScissors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> listA = new ArrayList<>();
        List<String> listB = new ArrayList<>();
        List<String> listC = new ArrayList<>();

        while (in.hasNext()) {
            String userId = in.next();
            String shape = in.next();
            if ("A".equals(shape)) {
                listA.add(userId);
            } else if ("B".equals(userId)) {
                listB.add(userId);
            } else {
                listC.add(userId);
            }
        }

        if (listA.isEmpty() && !listB.isEmpty() && !listC.isEmpty()) {
            printResult(listB);
        } else if (!listA.isEmpty() && listB.isEmpty() && !listC.isEmpty()) {
            printResult(listC);
        } else if (!listA.isEmpty() && !listB.isEmpty() && listC.isEmpty()) {
            printResult(listA);
        } else {
            System.out.println("NULL");
        }
    }

    private static void printResult(List<String> list) {
        Collections.sort(list);
        for (String userId : list) {
            System.out.println(userId);
        }
    }
}
