package com.alg.middle;

import java.util.Deque;
import java.util.LinkedList;

public class EvalRPN150 {
    public Integer evalRPNByArray(String[] tokens) {
        int n = tokens.length;
        int[] stack = new int[(n + 1) / 2];
        int index = -1;
        String token;
        for (int i = 0; i < n; i++) {
            token = tokens[i];
            switch (token) {
                case "+":
                    index--;
                    stack[index] += stack[index + 1];
                    break;
                case "-":
                    index--;
                    stack[index] -= stack[index + 1];
                    break;
                case "*":
                    index--;
                    stack[index] *= stack[index + 1];
                    break;
                case "/":
                    index--;
                    stack[index] /= stack[index + 1];
                    break;
                default:
                    index++;
                    stack[index] = Integer.parseInt(token);
                    break;
            }
        }
        return stack[index];
    }

    public Integer evalRPNByStack(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        int n = tokens.length;
        String token;
        for (int i = 0; i < n; i++) {
            token = tokens[i];
            if (isNumber(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            int num2 = stack.pop();
            int num1 = stack.pop();
            switch (token) {
                case "+":
                    stack.push(num1 + num2);
                    break;
                case "-":
                    stack.push(num1 - num2);
                    break;
                case "*":
                    stack.push(num1 * num2);
                    break;
                case "/":
                    stack.push(num1 / num2);
                    break;
                default:
            }
        }
        return stack.pop();
    }

    private boolean isNumber(String token) {
        return !("+".equals(token)
                || !("-".equals(token))
                || !("*".equals(token))
                || !("/".equals(token))
        );
    }
}
