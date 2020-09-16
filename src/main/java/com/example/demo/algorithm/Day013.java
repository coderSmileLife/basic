package com.example.demo.algorithm;

import java.util.HashMap;
import java.util.Map;


/**
 * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
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
 * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
 *
 * 
 *
 * 示例1:
 *
 * 输入:"III"
 * 输出: 3
 * 示例2:
 *
 * 输入:"IV"
 * 输出: 4
 * 示例3:
 *
 * 输入:"IX"
 * 输出: 9
 * 示例4:
 *
 * 输入:"LVIII"
 * 输出: 58
 * 解释: L = 50, V= 5, III = 3.
 * 示例5:
 *
 * 输入:"MCMXCIV"
 * 输出: 1994
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * 
 *
 * 提示：
 *
 * 题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
 * IC 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 * 关于罗马数字的详尽书写规则，可以参考 罗马数字 - Mathematics 。
 *
 *
 * @date 2020-09-07
 */
public class Day013 {

    // 初始化特殊值
    private static final Map<String, Integer> MAP = new HashMap<>();

    static {
        MAP.put("I", 1);
        MAP.put("IV", 4);
        MAP.put("V", 5);
        MAP.put("IX", 9);
        MAP.put("X", 10);
        MAP.put("XL", 40);
        MAP.put("L", 50);
        MAP.put("XC", 90);
        MAP.put("C", 100);
        MAP.put("CD", 400);
        MAP.put("D", 500);
        MAP.put("CM", 900);
        MAP.put("M", 1000);
    }

    public static void main(String[] args) {
        int toInt = romanToInt("MCMXCIV");
        System.out.println(toInt);
    }


    public static int romanToInt(String s) {
        // 特殊值直接返回
        if (MAP.containsKey(s)) return MAP.get(s);

        int result = 0;

        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            // 相邻两位字节包含在特殊值中，i要自增
            if (i + 1 < array.length && MAP.containsKey(s.substring(i, i + 2))) {
                result += MAP.get(s.substring(i, i + 2));
                ++i;
            } else {
                result += MAP.get(s.substring(i, i + 1));
            }
        }
        return result;
    }
}
