package com.example.hw;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <p>查找众数及中位数</p>
 * <p>
 *     众数是指一组数据中出现次数量多的那个数，众数可以是多个。
 *     中位数只是指把一组数据从小到大排列，最中间的那个数，如果这组数据的个数是奇数，那最中间那个就是中位数，如果这组数据的个数为偶数，那就把中间的两个数之和除以2，所得的结果就是中位数。
 *     查找整型数组中元素的众数并组成一个新的数组，求新数组的中位数
 * </p>
 * <p>
 *     输入描述：
 *          输入一个一维整型数组，数组大小取值范围 0<N<1000，数组中每个元素取值范围 0<E<1000
 * </p>
 * <p>
 *     输出描述：
 *          输出众数组成的新数组的中位数
 * </p>
 * @author zhenwu
 * @date 2024/7/22 20:43
 */
public class H88_FindModeAndMedian {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer, List<Integer>> map = Arrays.stream(in.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.groupingBy(i -> i));
        List<List<Integer>> list = new ArrayList<>(map.values());
        list.sort((l1, l2) -> l2.size() - l1.size());
        List<Integer> modeList = new ArrayList<>();
        int count = list.get(0).size();
        for (List<Integer> numList : list) {
            if (count != numList.size()) {
                break;
            }
            modeList.add(numList.get(0));
        }
        Collections.sort(modeList);
        int size = modeList.size();
        int mid = size / 2;
        if (size % 2 == 1) {
            System.out.println(modeList.get(mid));
        } else {
            System.out.println((modeList.get(mid) + modeList.get(mid - 1)) / 2);
        }
    }
}