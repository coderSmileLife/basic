package com.example.demo.algorithm;

import java.util.*;

/**
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * @date 2020-08-28
 */
public class Day001 {

    public static void main(String[] args) {
        int[] a = {2, 4, 3};
        int[] result = twoSum(a, 6);
        for (int b : result) {
            System.out.println(b);
        }
    }


    public static int[] twoSum(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();
        // 将数组元素与下标封装map，方便遍历判断
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        // 目标元素 - 遍历元素结果
        int tmp;
        // 针对目标值是元素2倍情况，控制不进行重复判断
        boolean check = true;
        // 元素下标集合
        Set<Integer> set = map.keySet();
        // 遍历下标
        for (Integer k : set) {
            Integer v = map.get(k);
            // 目标值 - 遍历元素
            tmp = target - v;
            // 判断所得值是否在数组中
            if (map.containsValue(tmp)) {
                // 1.存在2倍关系
                if (v == target / 2 && check && v != 0) {
                    // 根据value查询对应所有key
                    int[] arr = getMapKeyByValue(map, tmp);
                    if (arr.length > 1) {
                        result.add(arr[0]);
                        result.add(arr[1]);
                        check = false;
                    }
                    // 2.不存在2倍关系
                } else {
                    result.add(k);
                }
            }
        }

        // 如果存在2倍关系，但是数组中只有一个元素，比如6 和 3，数组中只有3，那么不作为结果返回
        if (result.size() < 2) {
            return new int[]{};
        }
        return result.stream().distinct().mapToInt(Integer::valueOf).toArray();
    }

    private static int[] getMapKeyByValue(Map<Integer, Integer> map, int target) {
        List<Integer> list = new ArrayList<>();

        map.forEach((k, v) -> {
            if (v.equals(target)) {
                list.add(k);
            }
        });
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
