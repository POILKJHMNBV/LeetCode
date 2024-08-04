package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>
 *     有一个特殊的 5键键盘，上面有 a,ctrl-c,ctrl-x,ctrl-v,ctrl-a五个键。
 *        a 键在屏幕上输出一个字母 a;
 *        ctrl-c 将当前选择的字母复制到剪贴板;
 *        ctrl-x 将当前选择的 字母复制到剪贴板，并清空选择的字母;
 *        ctrl-v 将当前剪贴板里的字母输出到屏幕;
 *        ctrl-a 选择当前屏幕上所有字母。
 * </p>
 * <p>
 *     注意: 1、剪贴板初始为空，新的内容被复制到剪贴板时会覆盖原来的内容
 *          2、当屏幕上没有字母时，ctrl-a无效
 *          3、当没有选择字母时，ctrl-c 和 ctrl-x无效
 *          4、当有字母被选择时，a和ctrl-v这两个有输出功能的键会先清空选择的字母，再进行输出 给定一系列键盘输入，输出最终屏幕上字母的数量。
 * </p>
 * <p>
 *     输入为一行，为简化解析，用数字 12345代表 a,ctrl-c,ctrl-x,ctrl-v,ctrl-a五个键的输入，数字用空格分隔
 *     输出一个数字，为最终屏目上字母的数量。
 * </p>
 * @author zhenwu
 * @date 2024/7/2 20:59
 */
public class H9_FiveKeyKeyBoard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String clipBoard = null;
        StringBuilder screen = new StringBuilder();
        int count = 0;
        boolean checkAll = false;
        for (int num : nums) {
           switch (num) {
               case 1:
                   if (checkAll) {
                       count = 1;
                       screen.delete(0, screen.length() - 1);
                   } else {
                       count++;
                   }
                   screen.append("a");
                   break;
               case 2:
                    if (checkAll) {
                        clipBoard = screen.toString();
                    }
                    break;
               case 3:
                   if (checkAll) {
                       clipBoard = screen.toString();
                       screen.delete(0, screen.length() - 1);
                       count = 0;
                   }
                   break;
               case 4:
                   if (checkAll) {
                       count = clipBoard.length();
                       screen.delete(0, screen.length() - 1);
                   } else {
                       count += clipBoard.length();
                   }
                   screen.append(clipBoard);
                   break;
               case 5:
                   checkAll = true;
                   break;
               default:
                   throw new IllegalArgumentException();
           }
        }
        System.out.println(count);
    }
}
