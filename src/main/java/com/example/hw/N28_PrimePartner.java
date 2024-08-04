package com.example.hw;

import java.util.*;

/**
 * @author zhenwu
 */
public class N28_PrimePartner {
    public static void main(String[] args) {
        char a = 'a';
        char z = 'z';
        int x = z -a;
        System.out.println(x);
    }

    public static void generatePairs(int[] arr,int index, List<Integer> current, List<List<Integer>> result) {
        if (index == arr.length) {
            List<Integer> copy = new ArrayList<>(current);
            result.add(copy);
            return;
        }

        for (int i = index + 1;i < arr.length;i++) {
            current.add(arr[index]);
            current.add(arr[i]);
            generatePairs(arr,i + 1,current,result);
            current.remove(current.size() - 1);
            current.remove(current.size() - 1);
        }
    }
}
