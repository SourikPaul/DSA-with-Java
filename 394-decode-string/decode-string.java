class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<String> stringStack = new ArrayDeque<>();

        String current = "";
        int count = 0;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                count = count * 10 + (ch - '0');
            }
            else if(ch == '['){
                countStack.push(count);
                stringStack.push(current);
                count = 0;
                current = "";   
            }  

            else if(ch == ']'){
                int repeat = countStack.pop();
                String previous = stringStack.pop();
                current = previous + current.repeat(repeat);
            }   
            else{
                current += ch;
            }
        }
        return current;

    }
}