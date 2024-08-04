package com.example.hw;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * <p>考古学家</p>
 * <p>
 *     有一个考古学家发现一个石碑，但是很可惜发现时其已经断成多段。
 *     原地发现N个断口整齐的石碑碎片，为了破解石碑内容，考古学家希望有程序能帮忙计算复原后的石碑文字组合数，你能帮忙吗？
 *     备注： 如果存在石碑碎片内容完全相同，则由于碎片间的顺序不影响复原后的碑文内容，仅相同碎片间的位置变化不影响组合
 * </p>
 * <p>
 *     输入描述：
 *      第一行输入N，N表示石碑碎片的个数
 *      第二行依次输入石碑碎片上的文字内容S共有N组
 * </p>
 * <p>
 *     输出描述：输出石碑文字的组合(按照升序排列)，行尾无多余空格
 * </p>
 * @author zhenwu
 * @date 2024/7/25 21:30
 */
public class H100_Archaeologist {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] fragments = new String[n];
        for (int i = 0; i < n; i++) {
            fragments[i] = in.next();
        }
        Set<String> result = new TreeSet<>();
        backtracking(result, "", fragments, new boolean[n], 0);
        for (String s : result) {
            System.out.println(s);
        }
    }

    private static void backtracking(Set<String> result, String s, String[] fragments, boolean[] visited, int index) {
        if (index == fragments.length) {
            result.add(s);
            return;
        }
        for (int i = 0; i < fragments.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            backtracking(result, s + fragments[i], fragments, visited, index + 1);
            visited[i] = false;
        }
    }
}
