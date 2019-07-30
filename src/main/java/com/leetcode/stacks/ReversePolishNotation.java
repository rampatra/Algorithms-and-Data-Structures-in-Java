package com.leetcode.stacks;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Level: Medium
 * Problem Link: https://leetcode.com/problems/evaluate-reverse-polish-notation
 * Problem Description:
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * <p>
 * Note:
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there
 * won't be any divide by zero operation.
 * <p>
 * Example 1:
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 * <p>
 * Example 2:
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 * <p>
 * Example 3:
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 *
 * @author rampatra
 * @since 2019-07-27
 */
public class ReversePolishNotation {

    /**
     * Time Complexity:
     * Space Complexity:
     * Runtime: <a href="https://leetcode.com/submissions/detail/246794713/">5 ms</a>.
     *
     * @param tokens
     * @return
     */
    public static int evalRPN(String[] tokens) {
        int operand1;
        int operand2;

        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    stack.push(operand2 - operand1);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    operand1 = stack.pop();
                    operand2 = stack.pop();
                    stack.push(operand2 / operand1);
                    break;
                default:
                    stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        assertEquals(18, evalRPN(new String[]{"18"}));
        assertEquals(9, evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        assertEquals(6, evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        assertEquals(22, evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
