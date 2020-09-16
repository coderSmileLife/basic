package com.example.demo.algorithm;


import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1到 3999 的范围内。
 *
 * 示例1:
 *
 * 输入:3
 * 输出: "III"
 * 示例2:
 *
 * 输入:4
 * 输出: "IV"
 * 示例3:
 *
 * 输入:9
 * 输出: "IX"
 * 示例4:
 *
 * 输入:58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例5:
 *
 * 输入:1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 
 * @date 2020-09-07
 */
public class Day012 {

    // 初始化特殊值
    private static final Map<Integer, String> MAP = new HashMap<>();

    static {
        MAP.put(1, "I");
        MAP.put(4, "IV");
        MAP.put(5, "V");
        MAP.put(9, "IX");
        MAP.put(10, "X");
        MAP.put(40, "XL");
        MAP.put(50, "L");
        MAP.put(90, "XC");
        MAP.put(100, "C");
        MAP.put(400, "CD");
        MAP.put(500, "D");
        MAP.put(900, "CM");
        MAP.put(1000, "M");
    }


    public static void main(String[] args) {
        String roman = intToRoman(40);
        System.out.println(roman);
    }


    public static String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        String s = String.valueOf(num);
        char[] array = s.toCharArray();

        for (int i = 0; i < array.length; i++) {
            // 当前位元素值
            int element = Integer.parseInt(String.valueOf(array[i]));
            // 所在位置，例如：十位
            int pow = (int) Math.pow(10, array.length - 1 - i);
            // 值
            int value = element * pow;

            // 特殊值
            if (MAP.containsKey(value)) {
                result.append(MAP.get(value));
            } else {
                // 非特殊值判断和5的关系，拼接1的个数
                int length = getLength(element);
                // 最后一位
                if (i == array.length - 1) {
                    // 大于5先拼接5，在拼接 length 个1
                    if (element > 5) {
                        result.append(MAP.get(5));
                    }
                    for (int j = 0; j < length; j++) {
                        result.append(MAP.get(1));
                    }
                } else {
                    // 大于5先拼接5，在拼接 length 个1
                    if (element > 5) {
                        result.append(MAP.get(5 * pow));
                    }
                    for (int k = 0; k < length; k++) {
                        result.append(MAP.get(pow));
                    }
                }
            }
        }

        return result.toString();
    }


    private static int getLength(int num) {
        if (num < 5) {
            return num;
        } else {
            return num - 5;
        }
    }

}