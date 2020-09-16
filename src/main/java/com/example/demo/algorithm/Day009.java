package com.example.demo.algorithm;


/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 121
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 * <p>
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 进阶:
 * <p>
 * 你能不将整数转为字符串来解决这个问题吗？
 *
 * @date 2020-09-04
 */
public class Day009 {


    public static void main(String[] args) {
        boolean palindrome = isPalindrome(-1);
        System.out.println(palindrome);
    }


    public static boolean isPalindrome(int x) {
        // 转字符串
        String s = String.valueOf(x);
        if (s.length() == 1) {
            return true;
            // 减号开头返回false
        } else if (s.startsWith("-")) {
            return false;
            // 反转比较字符串
        } else {
            StringBuilder stringBuilder = new StringBuilder(s);
            String s1 = stringBuilder.reverse().toString();
            return s.equals(s1);
        }
    }
}
