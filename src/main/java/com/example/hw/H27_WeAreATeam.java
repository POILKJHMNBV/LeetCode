package com.example.hw;

import java.util.Scanner;

/**
 * <p>We are a team</p>
 * <p>
 *      总共有 n 个人在机房，每个人有一个标号 (1<=标号<=n) ，他们分成了多个团队，需要你根据收到的 m 条消息判定指定的两个人是否在一个团队中，具体的:
 *          1.消息构成为 a b c，整数 a、b 分别代表两个人的标号，整数 c 代表指令。
 *          2.c == 0 代表a和b在一个团队内。
 *          3.c == 1 代表需要判定 a 和b 的关系，如果 a和b是一个团队，输出一行"we are a team",如果不是，输出一行"we are not a team"。
 *          4.c 为其他值，或当前行a或b 超出 1~n 的范围，输出 "da pian zi"。
 * </p>
 * <p>
 *     输入描述：
 *       1.第一行包含两个整数 n，m(1<=n.m<=100000).分别表示有n个人和 m 条消息。
 *       2.随后的 m 行，每行一条消息，消息格式为: a b c (1<=a,b<=n, 0<=c<=1)
 * </p>
 * <p>
 *     输出描述：
 *      1.c == 1.根据 a 和 b 是否在一个团队中输出一行字符串,在一个团队中输出 "we are a team", 不在一个团队中输出 "we are not a team"。
 *      2.c 为其他值，或当前行 a 或 b 的标号小于 1 或者大于 n 时，输出字符串 "da pian zi"。
 *      3.如果第一行 n 和 m的值超出约定的范围时，输出字符串"NULL"。
 * </p>
 * @author zhenwu
 * @date 2024/7/8 21:48
 */
public class H27_WeAreATeam {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        if (n < 1 || n > 100000 || m < 1 || m > 100000) {
            System.out.println("NULL");
            return;
        }
        int[][] messages = new int[m][3];
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            messages[i] = new int[]{a, b, c};
            if (c == 0) {
                unionFind.union(a, b);
            }
        }
        for (int[] message : messages) {
            if (message[2] == 0) {
                continue;
            }
            if (message[2] == 1) {
                if (unionFind.inSameTeam(message[0], message[1])) {
                    System.out.println("we are a team");
                } else {
                    System.out.println("we are not a team");
                }
            } else {
                System.out.println("da pian zi");
            }
        }
    }
}
class UnionFind {
    private final int[] teams;

    private int count;

    public UnionFind(int n) {
        this.teams = new int[n + 1];
        this.count = n;

        // 初始时每个人各自为一个团队
        for (int i = 0; i <= n; i++) {
            this.teams[i] = i;
        }
    }

    public void union(int x, int y) {
        int parentX = teams[x];
        int parentY = teams[y];

        if (parentX == parentY) {
            return;
        }

        // 合并
        for (int i = 0; i < teams.length; i++) {
            if (teams[i] == parentY) {
                teams[i] = parentX;
            }
        }
        this.count--;
    }

    public int getCount() {
        return this.count;
    }

    public boolean inSameTeam(int x, int y) {
        return teams[x] == teams[y];
    }
}