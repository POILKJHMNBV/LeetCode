package com.example.slidewindow;

/**
 * <p>L825:适龄的朋友</p>
 * @author zhenwu
 * @date 2025/2/23 9:30
 */
public class L825_NumFriendRequests {
    public static void main(String[] args) {
        int[] ages = {16, 16};
        System.out.println(numFriendRequests(ages));
    }

    /**
     * 滑动窗口
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     */
    private static int numFriendRequestsPro(int[] ages) {
        int[] count = new int[121];
        for (int age : ages) {
            // 统计每个年龄的人数
            count[age]++;
        }
        int res = 0;
        for (int ageX = 0, ageY = 0, cntWindow = 0; ageX <= 120; ageX++) {
            cntWindow += count[ageX];
            while (2 * ageY <= ageX + 14) {
                // 缩小窗口
                cntWindow -= count[ageY++];
            }
            if (cntWindow > 0) {
                // 减去给自己发的次数
                res += (count[ageX] * cntWindow - count[ageX]);
            }
        }
        return res;
    }

    /**
     * 暴力解法(TLE)
     * 时间复杂度: O(n * n)
     * 空间复杂度: O(1)
     */
    private static int numFriendRequests(int[] ages) {
        int n = ages.length;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (!notFriend(ages[i], ages[j])) {
                    res++;
                }
                if (!notFriend(ages[j], ages[i])) {
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean notFriend(int age1, int age2) {
        return age1 * 0.5 + 7 >= age2 || age2 > age1 || (age2 > 100 && age1 < 100);
    }
}
