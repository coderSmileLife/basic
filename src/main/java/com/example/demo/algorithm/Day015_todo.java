package com.example.demo.algorithm;


import java.util.*;


/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @date 2020-09-07
 */
public class Day015_todo {


    public static void main(String[] args) {
        List<List<Integer>> groups = threeSum(new int[]{-4, -8, 7, 13, 10, 1, -14, -13, 0, 8, 6, -13, -5, -4, -12, 2, -11, 7, -5, 0, -9, -14, -8, -9, 2, -7, -13, -3, 13, 9, -14, -6, 8, 1, 14, -5, -13, 8, -10, -5, 1, 11, -11, 3, 14, -8, -10, -12, 6, -8, -5, 13, -15, 2, 11, -5, 10, 6, -1, 1, 0, 0, 2, -7, 8, -6, 3, 3, -13, 8, 5, -5, -3, 9, 5, -4, -14, 11, -8, 7, 10, -6, -3, 11, 12, -14, -9, -1, 7, 5, -15, 14, 12, -5, -8, -2, 4, 2, -14, -2, -12, 6, 8, 0, 0, -2, 3, -7, -14, 2, 7, 12, 12, 12, 0, 9, 13, -2, -15, -3, 10, -14, -4, 7, -12, 3, -10});
        System.out.println(groups);
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        if (nums.length < 3) return result;

        Arrays.sort(nums);

        getGroups(nums, map, 0, 1);

        result.addAll(map.values());
        return result;
    }


    private static void getGroups(int[] nums, Map<String, List<Integer>> map, int firstIndex, int secondIndex) {
        for (int i = secondIndex + 1; i < nums.length; i++) {
//            int a = nums[firstIndex], b = nums[secondIndex], c = nums[i];
            if (0 == nums[firstIndex] + nums[secondIndex] + nums[i]) {
                map.putIfAbsent("" + nums[firstIndex] + nums[secondIndex] + nums[i], Arrays.asList(nums[firstIndex], nums[secondIndex], nums[i]));
            }
        }

        ++secondIndex;

        if (secondIndex > nums.length - 2) {
            ++firstIndex;
            secondIndex = firstIndex + 1;
        }

        if (firstIndex > nums.length - 3) {
            return;
        }

        getGroups(nums, map, firstIndex, secondIndex);
    }
}
