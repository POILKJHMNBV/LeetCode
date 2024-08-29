package com.example.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>L1431:拥有最多糖果的孩子</p>
 * @author zhenwu
 * @date 2024/8/29 21:43
 */
public class L1431_KidsWithCandies {
    public static void main(String[] args) {

    }

    private static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            res.add(candy + extraCandies >= max);
        }
        return res;
    }
}
