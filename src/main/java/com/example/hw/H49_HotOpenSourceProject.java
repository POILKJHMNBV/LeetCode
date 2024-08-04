package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>开源项目热榜</p>
 * <p>
 *     某个开源社区希望将最近热度比较高的开源项目出一个榜单，推荐给社区里面的开发者
 *     对于每个开源项目，开发者可以进行关注(watch)、收藏(star)、fork、提issue、提交合并请求(MR)等。
 *     数据库里面统计了每个开源项目关注、收藏、fork、issue、MR的数量，开源项目的热度根据这5个维度的加权求和进行排序
 *     榜单按照热度值降序排序，对于热度值相等的，按照项目名字转换为全小写字母后的字典序排序(a,b,c...x,y,)。
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入为N，表示开源项目的个数，0<100
 *          第二行输入为权重值列表，一共5个整型值，分别对应关注、收藏、fork、issue、MR的权重，权重取值0< W<50
 *          第二行开始接下来的N行为开源项目的统计维度，每一行的格式为: name nr_watch nr_star nr_fork nr_issue nr_mr
 *          其中name为开源项目的名字，由英文字母组成，长度< 50，其余5个整型值分别为该开源项目关注、收藏、fork、issue、MR的数量，数量取值0 < nr < 1000。
 * </p>
 * <p>
 *     输出描述：
 *          按照热度降序，输出开源项目的名字，对于热度值相等的，按照项目名字转换为全小写字母后的字典序排序(a>b>c ... >x > y > z)。
 * </p>
 * @author zhenwu
 * @date 2024/7/14 17:07
 */
public class H49_HotOpenSourceProject {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[] weights = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        OpenSourceProject[] openSourceProjects = new OpenSourceProject[n];
        for (int i = 0; i < n; i++) {
            String[] metaData = in.nextLine().split(" ");
            openSourceProjects[i] = new OpenSourceProject(weights, metaData);
        }
        Arrays.sort(openSourceProjects, (o1, o2) -> {
            int res = o2.hot - o1.hot;
            return res == 0 ? o1.name.compareTo(o2.name) : res;
        });
        for (OpenSourceProject openSourceProject : openSourceProjects) {
            System.out.println(openSourceProject.name);
        }
    }

    private static class OpenSourceProject {
        final String name;
        final int hot;

        public OpenSourceProject(int[] weights, String[] metaData) {
            this.name = metaData[0];
            int sum = 0;
            for (int i = 1; i < metaData.length; i++) {
                sum += weights[i - 1] * Integer.parseInt(metaData[i]);
            }
            this.hot = sum;
        }
    }
}
