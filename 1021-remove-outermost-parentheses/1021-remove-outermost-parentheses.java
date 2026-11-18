class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder S = new StringBuilder();
        int opened = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' && opened++ > 0) S.append(c);
            if (c == ')' && opened-- > 1) S.append(c);
        }
        return S.toString();
    }
}