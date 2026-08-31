import java.util.*;

class Solution {
    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {

            if (!token.equals("+") &&
                !token.equals("-") &&
                !token.equals("*") &&
                !token.equals("/")) {

                stack.push(Integer.parseInt(token));

            } else {

                int b = stack.pop();
                int a = stack.pop();

                int result;

                if (token.equals("+")) {
                    result = a + b;
                } 
                else if (token.equals("-")) {
                    result = a - b;
                } 
                else if (token.equals("*")) {
                    result = a * b;
                } 
                else {
                    result = a / b;
                }

                stack.push(result);
            }
        }

        return stack.peek();
    }
}