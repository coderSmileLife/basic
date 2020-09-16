package com.example.demo.algorithm;


import java.util.*;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 
 * @date 2020-09-09
 */
public class Day017 {

    private static final Map<String, List<String>> MAP = new HashMap<>();

    static {
        MAP.put("2", Arrays.asList("a", "b", "c"));
        MAP.put("3", Arrays.asList("d", "e", "f"));
        MAP.put("4", Arrays.asList("g", "h", "i"));
        MAP.put("5", Arrays.asList("j", "k", "l"));
        MAP.put("6", Arrays.asList("m", "n", "o"));
        MAP.put("7", Arrays.asList("p", "q", "r", "s"));
        MAP.put("8", Arrays.asList("t", "u", "v"));
        MAP.put("9", Arrays.asList("w", "x", "y", "z"));
    }


    public static void main(String[] args) {
        List<String> list = letterCombinations("5678");
        System.out.println(list);
    }


    public static List<String> letterCombinations(String digits) {
        // 特殊输入直接返回
        char[] array = digits.toCharArray();
        if (array.length == 0) {
            return new ArrayList<>();
        }

        if (array.length == 1) {
            return MAP.get(String.valueOf(array[0]));
        }

        // 从基础map中拿到对应的字母
        List<List<String>> list = new ArrayList<>();
        for (char c : array) {
            list.add(MAP.get(String.valueOf(c)));
        }

        // 先取前2个元素组合
        List<String> result = new ArrayList<>();
        List<String> tmpList = new ArrayList<>();
        List<String> l1 = list.get(0);
        List<String> l2 = list.get(1);
        for (String s : l1) {
            for (String s1 : l2) {
                tmpList.add(String.join("", s, s1));
            }
        }

        // 一次组合3个、4个、5个。。。
        for (int i = 2; i < list.size(); i++) {
            List<String> stringList = list.get(i);
            for (String s : stringList) {
                for (String s1 : tmpList) {
                    result.add(String.join("", s1, s));
                }
            }
            tmpList.removeAll(tmpList);
            tmpList.addAll(result);
            result.removeAll(result);
        }
        return tmpList;
    }

}
