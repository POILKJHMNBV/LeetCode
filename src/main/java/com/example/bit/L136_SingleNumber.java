package com.example.bit;

/**
 * <p>L136:只出现一次的数字</p>
 * <p>
 *     给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *     你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * </p>
 * @author zhenwu
 * @date 2024/8/8 22:26
 */
public class L136_SingleNumber {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}
