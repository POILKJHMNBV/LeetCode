package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>寻找最富裕的小家庭</p>
 * <p>
 *     在一棵树中，每个节点代表一个家庭成员，节点的数字表示其个人的财富值，一个节点及其直接相连的子节点被定义为一个小家庭现给你一棵树，请计算出最富裕的小家庭的财富和
 * </p>
 * <p>
 *     输入描述：
 *          第一行为一个数N，表示成员总数，成员编号1-N，1<=N<=1000
 *          第二行为N个空格分隔的数，表示编号1 - N 的成员的财富值。 0 <= 财富值 <= 1000000
 *          接下来 N-1 行，每行两个空格分隔的整数（N1,N2）， 表示 N1 是 N2 的父节点
 * </p>
 * <p>
 *     输出描述：
 *          最富裕的小家庭的财富和
 * </p>
 * @author zhenwu
 * @date 2024/7/13 14:44
 */
public class H39_FindMostRichFamily {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] assets = new int[n];
        for (int i = 0; i < n; i++) {
            assets[i] = in.nextInt();
        }
        int[] wealth = Arrays.copyOf(assets, n);
        for (int i = 0; i < n - 1; i++) {
            int parent = in.nextInt();
            int child = in.nextInt();
            wealth[parent - 1] += assets[child - 1];
        }
        System.out.println(Arrays.stream(wealth).max().getAsInt());
    }
}
