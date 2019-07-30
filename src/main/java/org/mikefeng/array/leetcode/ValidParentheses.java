package org.mikefeng.array.leetcode;

import org.mikefeng.array.ArrayStack;
import org.mikefeng.array.Stack;

/**
 * 有效的括号
 */
public class ValidParentheses {

    public boolean isValid(String parentheses) {
        Stack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character top = stack.pop();
                if (top == '{' && c != '}') {
                    return false;
                }
                if (top == '[' && c != ']') {
                    return false;
                }
                if (top == '(' && c != ')') {
                    return false;
                }
            }
        }
        // 只有栈里没有元素了才说明是完全匹配了
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("{[()]}"));
        System.out.println(validParentheses.isValid("[()]}"));
    }
}
