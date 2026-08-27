class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];

        for(int i = 0; i<temperatures.length; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prevDay = stack.peek();
                answer[prevDay] = i - prevDay;
                stack.pop();
            }
            stack.push(i);
        }
        return answer;
    }
}