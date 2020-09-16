package com.example.demo.algorithm;


/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2的31次,  2的31次 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 *
 * @date 2020-09-03
 */
public class Day007 {

    public static void main(String[] args) {
        int result = reverse(-1241041090);
        System.out.println(result);
    }


    public static int reverse(int x) {
        // int转string
        String s = String.valueOf(x);

        // 是否是带符号
        boolean hasSymbol = false;
        if (s.startsWith("-")) {
            hasSymbol = true;
            s = s.replaceFirst("-", "");
        }

        // 反转字符串
        String s1 = new StringBuffer(s).reverse().toString();

        //去掉首位0
        while (s1.startsWith("0")) {
            s1 = s1.replaceFirst("0", "");
        }

        // 转int，超过int范围返回0
        int result;
        try {
            result = Integer.parseInt(hasSymbol ? "-" + s1 : s1);
        } catch (Exception e) {
            result = 0;
        }
        return result;
    }
}
