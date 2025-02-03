package com.example.slidewindow;

/**
 * <p>L1052:爱生气的书店老板</p>
 * @author zhenwu
 * @date 2025/2/3 15:48
 */
public class L1052_MaxSatisfied {
    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }

    /**
     * 滑动窗口求最大值，窗口大小为minutes
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int totalMaxSatisfiedCustomer = 0, n = customers.length, addCustomers = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                totalMaxSatisfiedCustomer += customers[i];
            } else if (i < minutes) {
                addCustomers += customers[i];
            }
        }
        int l = 0, r = minutes, maxAddCustomers = addCustomers;
        while (r < n) {
            if (grumpy[l] == 1) {
                addCustomers -= customers[l];
            }
            if (grumpy[r] == 1) {
                addCustomers += customers[r];
            }
            maxAddCustomers = Math.max(addCustomers, maxAddCustomers);
            l++;
            r++;
        }
        totalMaxSatisfiedCustomer += maxAddCustomers;
        return totalMaxSatisfiedCustomer;
    }
}
