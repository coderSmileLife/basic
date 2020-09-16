package com.example.demo.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @date 2020-08-31
 */
public class Day002 {

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(4);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(5);
        list2.add(6);
        list2.add(6);
        List<Integer> list = sumList(list1, list2);
        System.out.println(list);
    }

    private static List<Integer> sumList(List<Integer> list1, List<Integer> list2){
        List<Integer> result = new ArrayList<>();
        // 相加和是否大于9进1
        boolean flag = false;
        for (int i = 0; i < list1.size(); i++) {
            Integer v1 = list1.get(i);
            Integer v2 = list2.get(i);
            int sum = v1 + v2;

            if (sum > 9) {
                if (flag) {
                    if (i == list1.size() - 1) {
                        result.add(sum - 10 + 1);
                        result.add(1);
                    } else {
                        result.add(sum - 10 + 1);
                    }
                } else {
                    result.add(sum - 10);
                }
                flag = true;
            } else {
                if (flag) {
                    if (sum + 1 > 9) {
                        if (i == list1.size() - 1) {
                            result.add(0);
                            result.add(1);
                        }
                        flag = true;
                    } else {
                        result.add(sum + 1);
                        flag = false;
                    }
                } else {
                    result.add(sum);
                    flag = false;
                }
            }
        }

        return result;
    }
}
