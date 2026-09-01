class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i = 0; i <= heights.length; i++){
            int currentHeight = (i == heights.length) ? 0 : heights[i];
            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]){
                int index = stack.pop();
                int height = heights[index];
                int width;
                if(stack.isEmpty()){
                    width = i;
                }
                else{
                    width = i - stack.peek() - 1;
                }
                int area = height * width;
                maxArea = Math.max(maxArea, area);

            }
            if(i < heights.length){
                stack.push(i);
            }
        }
        return maxArea;
    }
}