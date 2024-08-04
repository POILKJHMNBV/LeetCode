package com.example.hw;

import java.util.*;

/**
 * @author zhenwu
 */
public class N77_TheArrivalOfATrain {
    public static List<String> resList = new ArrayList<>();

    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            helper(nums, 0, 0, "");
            Collections.sort(resList);
            for (String s : resList) {
                System.out.println(s);
            }
        }
    }

    /**
     * @param nums      所有的火车
     * @param pushedNum 火车已经在栈里的数量
     * @param popNum    火车已全部出来的数量
     * @param res       单次结果
     */
    private static void helper(int[] nums, int pushedNum, int popNum, String res) {

        // 3. 火车全部都出来后，记录本次的结果，继续
        if (popNum == nums.length) {
            // 火车已全部出来,
            resList.add(res);
        }

        // 1. 得让所有火车都进栈，进栈后恢复原样
        if (pushedNum < nums.length) {
            // 进去一个，已经在栈里的数量多了一个，出来的没变，出来的结果没变
            stack.push(nums[pushedNum]);
            System.out.println("[1push] ==> " + nums[pushedNum]);
            helper(nums, pushedNum + 1, popNum, res);
            //恢复现场
            System.out.println("[1pop] ==> " + stack.pop());
        }

        // 2. 得让所有进去的火车全部出来，出来后也恢复原样
        if (!stack.empty()) {
            // 出来一个，已经在栈里的数量不动(没有新进去),出来的多了一个,结果加上出来的
            int pop = stack.pop();
            System.out.println("[2pop] ==> " + pop);
            helper(nums, pushedNum, popNum + 1, res + pop + " ");
            System.out.println("[2push] ==> " + pop);
            stack.push(pop); //恢复现场
        }
    }
}
