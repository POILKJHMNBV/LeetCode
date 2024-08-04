package com.example.hw;

import java.util.*;

/**
 * <p>精准核酸检测</p>
 * <p>
 *     为了达到新冠疫情精准防控的需要，为了避免全员核酸检测带来的浪费，需要精准圈定可能被感染的人群。
 *     现在根据传染病流调以及大数据分析，得到了每个人之间在时间、空间上是否存在轨迹的交叉。
 *     现在给定一组确诊人员编号(X1,X2,X3...Xn) 在所有人当中，找出哪些人需要进行核酸检测，输出需要进行核酸检测的人数。（注意:确诊病例自身不需要再做核酸检测)
 *     需要进行核酸检测的人，是病毒传播链条上的所有人员，即有可能通过确诊病例所能传播到的所有人。
 *     例如:A是确诊病例，A和B有接触、B和C有接触 C和D有接触，D和E有接触。那么B、C、D、E都是需要进行核酸检测的
 * </p>
 * <p>
 *     输入描述：
 *          第一行为总人数N
 *          第二行为确诊病例人员编号 (确证病例人员数量 < N) ，用逗号隔开
 *          接下来N行，每一行有N个数字，用逗号隔开，其中第i行的第个j数字表名编号i是否与编号j接触过。0表示没有接触，1表示有接触
 * </p>
 * <p>
 *     输出描述：
 *          输出需要做核酸检测的人数
 *          补充说明：人员编号从0开始，0 < N < 100
 * </p>
 * @see H27_WeAreATeam
 * @author zhenwu
 * @date 2024/7/14 16:00
 */
public class H47_PreciseNucleicAcidTesting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        int[] infectedArray = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        }


        UnionFind unionFind = new UnionFind(n);

        // 先将所有确诊人员合并为一组
        for (int i = 1; i < infectedArray.length; i++) {
            unionFind.union(infectedArray[0], infectedArray[i]);
        }

        // 进行合并操作
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (grid[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (unionFind.inSameTeam(infectedArray[0], i)) {
                count++;
            }
        }
        System.out.println(count - infectedArray.length);
    }
}
