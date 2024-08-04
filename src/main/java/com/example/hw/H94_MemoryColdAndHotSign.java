package com.example.hw;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * <p>内存冷热标记</p>
 * <p>
 *     现代计算机系统通常存在多级的存储设备，针对海量的 wordload 的优化的一种思路是将热点内存页优化先放到快速存储层级，这就需要对内存页进行冷热标记。
 *     一种典型的方案是基于内存页的访问频次进行标记，如果统计窗口内访问次数大于等于设定阈值，要实现基于频次的冷热标记。内存页使用页框号作为标识。
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入为 N, 表示访存序列的记录条数， 0 < N ≤ 10000。
 *          第二行为访问内存序列，空格间隔的 N 个内存页框号，页面号范围 0 ~ 65535，同一个页框号可能重复出现，出现的次数即为对应框号的频次。
 *          第三行为热内存的频次阈值 T ，正整数范围 1 ≤ T ≤ 10000。
 * </p>
 * <p>
 *     输出描述：
 *          第一行为输出标记为热内存的内存页个数，如果没有被标记为热内存的，则输出 0。
 *          如果第一行大于 0，则接下来按照访问频次降序输出内存页框号，一行一个，频次一样的页框号，页框号小的排前面。
 * </p>
 * @author zhenwu
 * @date 2024/7/23 20:26
 */
public class H94_MemoryColdAndHotSign {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        TreeMap<Integer, Integer> counter = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
        }
        int t = in.nextInt();
        long count = counter.values().stream().filter(num -> num >= t).count();
        System.out.println(count);
        if (count > 0) {
            counter.forEach((k, v) -> {
                if (v >= t) {
                    System.out.println(k);
                }
            });
        }
    }
}
