package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 寻找两个正序数组的中位数
 *
 * 给定两个大小为 m 和 n 的正序（从小到大）数组nums1 和nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为O(log(m + n))。
 *
 * 你可以假设nums1和nums2不会同时为空。
 *
 *
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * @date 2020-09-01
 */
public class Day004 {


    public static void main(String[] args) {
        double result = findMedianSortedArrays(new int[]{1, 1}, new int[]{1, 2});
        System.out.println(result);
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result;
        // 将两个数组元素装进list
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            list.add(i);
        }
        for (int i : nums2) {
            list.add(i);
        }

        // 对list元素排序
        List<Integer> collect = list.stream().sorted().collect(Collectors.toList());
        // 判断list元素个数是奇数还是偶数，奇数直接取中间元素，偶数取中间两元素取平均值
        int size = collect.size();
        if (size % 2 == 0) {
            int a = collect.get(size / 2 - 1);
            int b = collect.get(size / 2);
            result = (a + b) / 2.0;
        } else {
            int index = (size + 1) / 2 - 1;
            result = collect.get(index);
        }

        return result;
    }
}
