package com.example.demo.algorithm;


/**
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串""。
 *
 * 示例1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例2:
 *
 * 输入: ["ca","a"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母a-z。
 *
 * @date 2020-09-07
 */
public class Day014 {


    public static void main(String[] args) {
        String s = longestCommonPrefix(new String[]{"ca","a"});
        System.out.println(s);
    }



    public static String longestCommonPrefix(String[] strs) {
        // 找出最短字符串
        int length = Integer.MAX_VALUE;
        String param = "";
        for (String str : strs) {
            int tmpLength = str.length();
            if (tmpLength <= length) {
                length = tmpLength;
                param = str;
            }
        }

        // 遍历判断
        boolean flag;
        do {
            flag = false;
            for (String str : strs) {
                // 包含关系必须是以公共字符串开头--公共前缀
                if (str.indexOf(param) != 0) {
                    flag = true;
                    // 不满足末尾抹去一位
                    param = param.substring(0, param.length() - 1);
                }
            }
        } while (flag);

        return param;
    }
}
