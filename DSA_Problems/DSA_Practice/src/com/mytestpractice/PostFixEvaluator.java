package com.mytestpractice;

import java.util.Stack;

public class PostFixEvaluator {

    /**
     * Evaluates a simple postfix expression given as an array of strings.
     * Supports addition, subtraction, multiplication, and division.
     *
     * @param expression An array of strings representing the postfix expression.
     * Numbers are expected to be valid integers.
     * @return The result of the evaluation.
     * @throws IllegalArgumentException if the expression is invalid (e.g., insufficient operands, unknown operator).
     */
    public static int evaluatePostfix(String[] expression) {
        if (expression == null || expression.length == 0) {
            throw new IllegalArgumentException("Expression cannot be null or empty.");
        }

        Stack<Integer> stack = new Stack<>();

        for (String token : expression) {
            if (isNumeric(token)) {
                // If it's a number, push it onto the stack
                stack.push(Integer.parseInt(token));
            } else {
                // If it's an operator, pop two operands, perform operation, and push result
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression: Insufficient operands for operator " + token);
                }
                int operand2 = stack.pop(); // Second operand
                int operand1 = stack.pop(); // First operand

                int result;
                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        if (operand2 == 0) {
                            throw new ArithmeticException("Division by zero.");
                        }
                        result = operand1 / operand2;
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown operator: " + token);
                }
                stack.push(result);
            }
        }

        // After processing all tokens, the stack should contain only the final result
        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression: Too many operands or operators.");
        }

        return stack.pop();
    }

    /**
     * Helper method to check if a string represents a numeric value.
     * @param str The string to check.
     * @return true if the string is numeric, false otherwise.
     */
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        // Test cases
        String[] exp1 = {"5", "3", "+"}; // Expected: 8
        System.out.println("Expression [5, 3, '+'] evaluates to: " + evaluatePostfix(exp1));

        String[] exp2 = {"10", "2", "/"}; // Expected: 5
        System.out.println("Expression [10, 2, '/'] evaluates to: " + evaluatePostfix(exp2));

        String[] exp3 = {"4", "5", "*", "2", "+"}; // Expected: (4 * 5) + 2 = 22
        System.out.println("Expression [4, 5, '*', 2, '+'] evaluates to: " + evaluatePostfix(exp3));

        String[] exp4 = {"10", "5", "3", "-", "*"}; // Expected: 10 * (5 - 3) = 20
        System.out.println("Expression [10, 5, 3, '-', '*'] evaluates to: " + evaluatePostfix(exp4));

        String[] exp5 = {"7"}; // Expected: 7
        System.out.println("Expression [7] evaluates to: " + evaluatePostfix(exp5));

        // Test cases for invalid expressions
        try {
            String[] invalidExp1 = {"5", "+"}; // Insufficient operands
            System.out.println("Expression [5, '+'] evaluates to: " + evaluatePostfix(invalidExp1));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception for invalid expression: " + e.getMessage());
        }

        try {
            String[] invalidExp2 = {"5", "3", "2", "+"}; // Too many operands
            System.out.println("Expression [5, 3, 2, '+'] evaluates to: " + evaluatePostfix(invalidExp2));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception for invalid expression: " + e.getMessage());
        }

        try {
            String[] invalidExp3 = {"5", "0", "/"}; // Division by zero
            System.out.println("Expression [5, 0, '/'] evaluates to: " + evaluatePostfix(invalidExp3));
        } catch (ArithmeticException e) {
            System.out.println("Caught expected exception for division by zero: " + e.getMessage());
        }
    }
}
