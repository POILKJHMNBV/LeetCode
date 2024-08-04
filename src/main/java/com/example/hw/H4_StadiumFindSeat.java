package com.example.hw;

import java.util.Scanner;

/**
 * <p>体育场找座位</p>
 * <p>
 *     在一个大型体育场内举办了一场大型活动，由于疫情防控的需要，要求每位观众的必须间隔至少一个空位才允许落座。
 *     现在给出一排观众座位分布图，座位中存在已落座的观众，请计算出，在不移动现有观众座位的情况下，最多还能坐下多少名观众。
 * </p>
 * <p>
 *     输入描述：一个数组，用来标识某一排座位中，每个座位是否已经坐人。0表示该座位没有坐人，1表示该座位已经坐人。
 * </p>
 * <p>
 *     输出描述：整数，在不移动现有观众座位的情况下，最多还能坐下多少名观众。
 * </p>
 * @author zhenwu
 * @date 2024/6/27 23:01
 */
public class H4_StadiumFindSeat {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] chars = in.nextLine().toCharArray();
        int len = chars.length;

        char preCh = '0';
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (preCh == '0' && chars[i] == '0' && (i + 1 == len || chars[i + 1] == '0')) {
                count++;
                chars[i] = '1';
            }
            preCh = chars[i];
        }
        System.out.println(count);
    }
}
