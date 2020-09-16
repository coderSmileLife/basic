package com.example.demo.algorithm;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * 
 * @date 2020-09-10
 */
public class Day018 {

    public static void main(String[] args) {
        System.out.println(isValid(""));
    }


    public static boolean isValid(String s) {
        int n = s.length();
        // 有单个括号直接返回false
        if (n % 2 == 1) {
            return false;
        }

        // 左右括号对应关系
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        // 栈，存储左括号
        Deque<Character> stack = new LinkedList<>();
        // 遍历字符串
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            // 如果map.key包含当前字符
            if (pairs.containsKey(ch)) {
                // 栈顶的括号和当前括号不对应
                if (stack.peek() != pairs.get(ch)) {
                    return false;
                }
                // 否则出栈栈顶字符
                stack.pop();
            } else {
                // 是左括号直接入栈
                stack.push(ch);
            }
        }
        // 最后栈内位空，说明括号都全部闭合了
        return stack.isEmpty();
    }

}
