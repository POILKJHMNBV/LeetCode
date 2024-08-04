package com.example.hw;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <p>手机App防沉迷系统</p>
 * <p>
 *     智能手机方便了我们生活的同时，也侵占了我们不少的时间。“手机Ap防沉迷系统” 能够让我们每天合理的规划手机App使用时间，在正确的时间做正确的事。
 *     它的大概原理是这样的:
 *          1.在一天24小时内，可注册每个App的允许使时段;
 *          2.一个时间段只能使用一个APP， 不能在同时注册App2 和 App3;
 *          3.App有优先级，数值越高，优先级越高。注册使用时段时，如果高优先级的App时间和低优先级的时段有冲突，则系统会自动注销低优先级的时段
 *          4.如果App的优先级相同，则后添加的App不能注册。
 *      请编程实现，根据输入数据注册App，并根据输入的时间点，返回时间点注册的App名称，如果该时间点没有注册任何App，请返回字符串“NA"。
 * </p>
 * <p>
 *     输入描述：
 *          第一行表示注册的App数 N(N <= 100)
 *          第二部分包括 N 行，每行表示一条App注册数据
 *          最后一行输入一个时间点，程序即返回注册点可App
 * </p>
 * <p>
 *     输出描述：
 *          输出一个字符串，表示App名称，或NA表示空闲时间。
 * </p>
 * @author zhenwu
 * @date 2024/7/21 21:28
 */
public class H86_AppAntiAddictionSystem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Map<TimeInterval, Application> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Application application = new Application(in.nextLine());
            TimeInterval newTimeInterval = new TimeInterval(application.beginTime, application.endTime);
            boolean cover = false;
            for (TimeInterval oldTimeInterval : map.keySet()) {
                Application oldApp = map.get(oldTimeInterval);
                if (application.priority > oldApp.priority && canCover(oldTimeInterval, newTimeInterval)) {
                    map.put(newTimeInterval, application);
                    map.remove(oldTimeInterval);
                    cover = true;
                }
            }
            if (!cover) {
                map.put(newTimeInterval, application);
            }
        }
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime targetTime = LocalTime.parse(in.nextLine(), timeFormatter);
        for (TimeInterval timeInterval : map.keySet()) {
            if (inRange(targetTime, timeInterval.beginTime, timeInterval.endTime)) {
                System.out.println(map.get(timeInterval).name);
                return;
            }
        }
        System.out.println("NA");
    }

    private static boolean canCover(TimeInterval oldTimeInterval, TimeInterval newTimeInterval) {
        LocalTime oldBeginTime = oldTimeInterval.beginTime;
        LocalTime oldEndTime = oldTimeInterval.endTime;
        LocalTime newBeginTime = newTimeInterval.beginTime;
        LocalTime newEndTime = newTimeInterval.endTime;
        return inRange(newBeginTime, oldBeginTime, oldEndTime) || inRange(newEndTime, oldBeginTime, oldEndTime)
                || inRange(oldBeginTime, newBeginTime, newEndTime) || inRange(oldEndTime, newBeginTime, newEndTime);
    }

    private static boolean inRange(LocalTime targetTime, LocalTime beginTime, LocalTime endTime) {
        return (targetTime.equals(beginTime) || targetTime.isAfter(beginTime)) && (targetTime.equals(endTime) || targetTime.isBefore(endTime));
    }

    private static class TimeInterval {
        final LocalTime beginTime;
        final LocalTime endTime;

        public TimeInterval(LocalTime beginTime, LocalTime endTime) {
            this.beginTime = beginTime;
            this.endTime = endTime;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TimeInterval that = (TimeInterval) o;

            if (beginTime != null ? !beginTime.equals(that.beginTime) : that.beginTime != null) return false;
            return endTime != null ? endTime.equals(that.endTime) : that.endTime == null;
        }

        @Override
        public int hashCode() {
            int result = beginTime != null ? beginTime.hashCode() : 0;
            result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
            return result;
        }
    }

    private static class Application {
        final String name;
        final int priority;
        final LocalTime beginTime;
        final LocalTime endTime;

        public Application(String s) {
            String[] metaData = s.split(" ");
            this.name = metaData[0];
            this.priority = Integer.parseInt(metaData[1]);
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
            this.beginTime = LocalTime.parse(metaData[2], timeFormatter);
            this.endTime = LocalTime.parse(metaData[3], timeFormatter);
        }
    }
}
