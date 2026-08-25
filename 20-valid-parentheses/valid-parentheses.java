import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } 
            else {
                if (stack.isEmpty()) {
                    return false;
                }

                if (ch == ')' && stack.peek() != '(') {
                    return false;
                }

                if (ch == ']' && stack.peek() != '[') {
                    return false;
                }

                if (ch == '}' && stack.peek() != '{') {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}