package com.example.hw;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>AI面板识别</p>
 * <p>
 *     AI识别到面板上有N（1 ≤ N ≤ 100）个指示灯，灯大小一样，任意两个之间无重叠。
 *     由于AI识别误差，每次别到的指示灯位置可能有差异，以4个坐标值描述AI识别的指示灯的大小和位置(左上角x1,y1，右下角x2,y2)，
 *     请输出先行后列排序的指示灯的编号，排序规则：
 *          1.每次在尚未排序的灯中挑选最高的灯作为的基准灯；
 *          2.找出和基准灯属于同一行所有的灯进行排序。两个灯高低偏差不超过灯半径算同一行（即两个灯坐标的差 ≤ 灯高度的一半）
 * </p>
 * <p>
 *     输入描述:
 *          第一行为N，表示灯的个数 接下来N行，每行为1个灯的坐标信息，格式为：编号 x1 y1 x2 y2
 *              编号全局唯一
 *              1 ≤ 编号 ≤ 100
 *              0 ≤ x1 < x2 ≤ 1000
 *              0 ≤ y1 < y2 ≤ 1000
 * </p>
 * <p>
 *     输出描述：
 *          排序后的编号列表，编号之间以空格分隔
 * </p>
 * @author zhenwu
 * @date 2024/7/7 11:13
 */
public class H23_AIRecognition {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        List<Light> lightList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            lightList.add(new Light(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
        }

        List<Light> res = new ArrayList<>();
        while (!lightList.isEmpty()) {
            lightList.sort(Comparator.comparingInt(o -> o.y1));
            Light firstLight = lightList.get(0);
            int radius = (firstLight.y2 - firstLight.y1) / 2;
            List<Light> list = lightList.stream()
                    .filter(l -> l.y1 - firstLight.y1 <= radius)
                    .sorted(Comparator.comparing(o -> o.x1))
                    .collect(Collectors.toList());
            res.addAll(list);
            for (Light light : list) {
                lightList.remove(light);
            }
        }
        for (Light light : res) {
            System.out.print(light.num + " ");
        }
    }

    private static class Light {
        final int num;
        final int x1, y1, x2, y2;
        public Light(int num, int x1, int y1, int x2, int y2) {
            this.num = num;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Light light = (Light) o;

            if (num != light.num) return false;
            if (x1 != light.x1) return false;
            if (y1 != light.y1) return false;
            if (x2 != light.x2) return false;
            return y2 == light.y2;
        }

        @Override
        public int hashCode() {
            int result = num;
            result = 31 * result + x1;
            result = 31 * result + y1;
            result = 31 * result + x2;
            result = 31 * result + y2;
            return result;
        }
    }
}
