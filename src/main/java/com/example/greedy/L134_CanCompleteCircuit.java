package com.example.greedy;

/**
 * <p>L134:加油站</p>
 * @author zhenwu
 * @date 2024/10/16 21:54
 */
public class L134_CanCompleteCircuit {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuitPro(gas, cost));
    }

    /**
     * 暴力求解，依次从每一个加油站出发，判断能否完成一圈，即返回出发点
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 超时
     * @param gas gas[i]表示第i个加油站能提供的油量
     * @param cost cost[i]表示从第i个加油站到下一个加油站的油量
     * @return 出发点
     */
    private static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int j = i, remain = gas[i];
            while (remain >= cost[j]) {
                remain = remain - cost[j] + gas[(j + 1) % len];
                j = (j + 1) % len;
                if (j == i) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 贪心算法，从出发点出发，如果剩余油量小于0，则将出发点移动到下一个加油站
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param gas gas[i]表示第i个加油站能提供的油量
     * @param cost cost[i]表示从第i个加油站到下一个加油站的油量
     * @return 出发点
     */
    private static int canCompleteCircuitPro(int[] gas, int[] cost) {
        int totalGas = 0;
        int currentGas = 0;
        int startingStation = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];
            System.out.println("totalGas: "+totalGas);
            System.out.println("currentGas: "+currentGas);

            // 如果当前汽油量不足以到达下一个加油站，则尝试从下一个加油站开始
            if (currentGas < 0) {
                startingStation = (i + 1) % gas.length; // 更新起始加油站为下一个加油站
                currentGas = 0; // 重置当前汽油量
            }
        }

        // 如果总汽油量小于总消耗量，则无法绕环路行驶一周
        if (totalGas < 0) {
            return -1;
        }

        return startingStation;
    }
}
