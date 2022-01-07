package java;

import java.util.Stack;

class MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        int max = 0;
        for (char c : charArr) {
            if (c == '(') {
                stack.push(c);
            }
            if (c == ')') {
                if (!stack.isEmpty()) {
                    max = Math.max(max, stack.size());
                    stack.pop();
                }
            }
        }
        return max;
    }
}