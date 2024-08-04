package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>考勤信息</p>
 * <p>
 *     公司用一个字符串来表示员工的出勤信息
 *          absent:缺勒
 *          late: 迟到
 *          leaveearly: 早退
 *          present: 正常上班
 *     现需根据员工出勤信息，判断本次是否能获得出勤奖，能获得出勤奖的条件如下:
 *          缺勤不超过一次
 *          没有连续的迟到/早退
 *          任意连续7次考勤，缺勒/迟到/早退不超过3次
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入一个整数n，表示有多少个员工
 *          后面n行，每一行输入若干个字符串，表示第i名员工的出勤信息
 * </p>
 * <p>
 *     输出描述：
 *          输出n行，每一行表示这名员工能否获得出勤奖，如果可以，则输出“true"，否则输出”false"
 * </p>
 * @author zhenwu
 * @date 2024/7/18 20:40
 */
public class H67_Attendance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String[] attendances = new String[n];
        for (int i = 0; i < n; i++) {
            attendances[i] = in.nextLine();
        }
        for (String attendance : attendances) {
            System.out.println(attendanceAward(attendance) + " ");
        }
    }

    private static boolean attendanceAward(String attendance) {
        String[] attendanceArray = attendance.split(" ");
        if (Arrays.asList(attendanceArray).contains("absent")) {
            // 有缺勤记录
            return false;
        }
        int length = attendanceArray.length;
        for (int i = 0; i < length - 1; i++) {
            String s1 = attendanceArray[i];
            String s2 = attendanceArray[i + 1];
            if (("late".equals(s1) || "leaveearly".equals(s1))
            && ("late".equals(s2) || "leaveearly".equals(s2))) {
                return false;
            }
        }
        if (length < 7) {
            return true;
        }
        int count = 0;
        for (int i = 0; i < 7; i++) {
            String s = attendanceArray[i];
            if ("late".equals(s) || "leaveearly".equals(s)) {
                count++;
            }
        }
        int l = 0, r = 6;
        while (r < length) {
            if (count > 3) {
                return false;
            }
            if ("late".equals(attendanceArray[l]) || "leaveearly".equals(attendanceArray[l])) {
                count--;
            }
            l++;
            r++;
            if (r < length && ("late".equals(attendanceArray[r]) || "leaveearly".equals(attendanceArray[r]))) {
                count++;
            }
        }
        return true;
    }
}
