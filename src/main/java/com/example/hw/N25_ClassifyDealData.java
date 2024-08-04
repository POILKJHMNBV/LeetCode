package com.example.hw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author zhenwu
 */
public class N25_ClassifyDealData {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String seq1 = br.readLine();
        String seq2 = br.readLine();
        String[] strArray1 = seq1.split(" ");
        String[] strArray2 = seq2.split(" ");

        int len = Integer.parseInt(strArray1[0]);
        String[] iArray = new String[len];
        System.arraycopy(strArray1, 1, iArray, 0, len);

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < strArray2.length; i++) {
            set.add(Integer.parseInt(strArray2[i]));
        }
        int[] nums = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            nums[i++] = num;
        }
        Arrays.sort(nums);

        Map<String, Map<Integer, String>> map = new LinkedHashMap<>();
        for (int num : nums) {
            for (int j = 0; j < len; j++) {
                String key = String.valueOf(num);
                if (iArray[j].contains(key)) {
                    Map<Integer, String> m = map.getOrDefault(key, new LinkedHashMap<>());
                    m.put(j, iArray[j]);
                    map.put(key, m);
                }
            }
        }
        int totalCount = map.size() * 2;
        for (Map<Integer, String> value : map.values()) {
            totalCount += value.size() * 2;
        }
        System.out.print(totalCount + " ");
        map.forEach((key, value) -> {
            System.out.print(key + " ");
            System.out.print(value.size() + " ");
            value.forEach((k, v) -> {
                System.out.print(k + " " + v +" ");
            });
        });
    }
}
