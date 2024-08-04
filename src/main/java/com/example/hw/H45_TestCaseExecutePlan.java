package com.example.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <p>测试用例执行计划</p>
 * <p>
 *     某个产品当前迭代周期内有N个特性（F1, F2, ..., FN）需要进行覆盖测试，每个特性都被评估了对应的优先级，特性使用其ID作为下标进行标识。
 *     设计了M个测试用例（T1, T2,...,TM），每个用例对应了一个覆盖特性的集合，测试用例使用其ID作为下标进行标识，测试用例的优先级定义为其覆盖的特性的优先级之和。
 *     在开展测试之前，需要制定测试用例的执行顺序，规则为：优先级大的用例先执行，如果存在优先级相同的用例，用例ID小的先执行。
 * </p>
 * <p>
 *     输入描述：
 *          第一行输入为N和M，N表示特性的数量，M表示测试用例的数量。
 *          之后N行表示特性ID=1到特性ID=N的优先级。
 *          再接下来M行表示测试用例ID=1到测试用例ID=M关联的特性的ID的列表。
 * </p>
 * <p>
 *     输出描述：
 *          按照执行顺序（优先级从大到小）输出测试用例的ID，每行一个ID。
 * </p>
 * @author zhenwu
 * @date 2024/7/14 15:11
 */
public class H45_TestCaseExecutePlan {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int characterNum = in.nextInt();
        int testCaseNum = in.nextInt();
        int[] priorities = new int[characterNum];
        for (int i = 0; i < characterNum; i++) {
            priorities[i] = in.nextInt();
        }
        in.nextLine();

        // 利用二维数组存储测试用例：num[0]表示用例编号，num[1]表示用例优先级
        int[][] testCases = new int[testCaseNum][2];
        for (int i = 0; i < testCaseNum; i++) {
            int[] array = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            testCases[i][0] = i + 1;
            for (int index : array) {
                testCases[i][1] += priorities[index - 1];
            }
        }

        Arrays.sort(testCases, (arr1, arr2) -> {
            int res = arr2[1] - arr1[1];
            return res == 0 ? arr1[0] - arr2[0] : res;
        });
        for (int[] testCase : testCases) {
            System.out.println(testCase[0]);
        }
    }
}
