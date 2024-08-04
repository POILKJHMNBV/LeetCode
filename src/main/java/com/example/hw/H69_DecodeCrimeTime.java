package com.example.hw;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * <p>解密犯罪时间</p>
 * <p>
 *     警察在侦破一个案件时，得到了线人给出的可能犯罪时间，形如 HH:MM 表示的时刻。
 *     根据警察和线人的约定，为了隐蔽，该事件是修改过的，解密规则为：
 *     利用当前出现过的数字，构造下一个距离当前事件最近的时刻，则该时间为可能的犯罪的时间。每个数字都可以被无限次使用。
 * </p>
 * <p>
 *     输入描述：形如 HH:SS 字符串，表示原始输入。
 * </p>
 * <p>
 *     输出描述：HH:SS 字符串，表示推理处理的犯罪时间。
 *     备注：
 *          可以保证现任给定的字符串一定是合法的，例如，"01:3501:35" 和 "11:0811:08" 是合法的，"1:351:35"和"11:811:8" 是不合法的。
 *          最近的时刻可能在第二天
 * </p>
 * @author zhenwu
 * @date 2024/7/18 21:51
 */
public class H69_DecodeCrimeTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String targetTimeStr = in.nextLine();
        int[] nums = new int[4];
        nums[0] = targetTimeStr.charAt(0) - '0';
        nums[1] = targetTimeStr.charAt(1) - '0';
        nums[2] = targetTimeStr.charAt(3) - '0';
        nums[3] = targetTimeStr.charAt(4) - '0';
        LocalTime targetTime = LocalTime.parse(targetTimeStr, DateTimeFormatter.ofPattern("HH:mm"));
        TreeMap<Long, String> res = new TreeMap<>();
        backtracking(nums, targetTime, "", 0, res);
        Map.Entry<Long, String> entry = res.pollFirstEntry();
        System.out.println(entry.getValue());
    }

    private static void backtracking(int[] nums,
                                     LocalTime targetTime,
                                     String numStr,
                                     int index,
                                     TreeMap<Long, String> res) {
        if (numStr.length() == 4) {
            String timeStr = numStr.substring(0, 2) + ":" + numStr.substring(2);
            LocalTime time = LocalTime.parse(timeStr, DateTimeFormatter.ofPattern("HH:mm"));
            if (time.equals(targetTime)) {
                return;
            }
            long diffMills;
            if (time.isAfter(targetTime)) {
                diffMills = Duration.between(targetTime, time).abs().toMillis();
            } else {
                LocalDate now = LocalDate.now();
                LocalDateTime targetLocalTime = LocalDateTime.of(now, targetTime);
                LocalDateTime nextDateTime = LocalDateTime.of(now.plusDays(1), time);
                diffMills = Duration.between(targetLocalTime, nextDateTime).abs().toMillis();
            }
            res.put(diffMills, timeStr);
            return;
        }
        for (int num : nums) {
            if (index == 0 && num > 2) {
                continue;
            }
            if (index == 1 && (numStr.charAt(0) - '0' == 2) && num > 3) {
                continue;
            }
            if (index == 2 && num > 5) {
                continue;
            }
            backtracking(nums, targetTime ,numStr + num, index + 1, res);
        }
    }
}
