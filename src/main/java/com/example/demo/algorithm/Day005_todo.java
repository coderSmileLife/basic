package com.example.demo.algorithm;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * TODO 未完成，之后再做
 *
 *
 * @date 2020-09-01
 */
public class Day005_todo {


    public static void main(String[] args) {
        String s = RandomStringUtils.randomAlphanumeric(1000);
        String result = longestPalindrome(s);
        System.out.println(result);
    }


    public static String longestPalindrome(String s) {
        String result = "";

        if ("".equals(s)) {
            return "";
        }

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int rightIndex = i;

            while (rightIndex + 1 <= chars.length) {
                if (!isPalin(s.substring(i, rightIndex + 1))) {
                    // 不断地移动右指针
                    ++rightIndex;
                } else {
                    if (s.substring(i, rightIndex + 1).length() >= result.length()) {
                        result = s.substring(i, rightIndex + 1);
                    }
                    // 不断地移动右指针
                    ++rightIndex;
                }
            }
        }

        if (StringUtils.isBlank(result)) {
            result = String.valueOf(s.charAt(0));
        }

        return result;
    }


    public static boolean isPalin(String data) {
        String s = data.replaceAll("", "#");
        s = "#" + s + "#";
        int length = s.length();
        int centerIndex = (length + 1) / 2 - 1;
        String replace = replace(s, centerIndex, ' ');
        String[] split = replace.split(" ");
        String s1 = split[0];
        String s2 = split[1];
        s2 = new StringBuffer(s2).reverse().toString();
        return s1.equals(s2);
    }


    private static String replace(String source, int index, char replacement) {
        char[] chars = source.toCharArray();
        chars[index] = replacement;
        return new String(chars);
    }
}
