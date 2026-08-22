class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length - 1;
        while(left <= right){
            if(Math.abs(nums[left]) > Math.abs(nums[right])){
                ans[pos] = nums[left] * nums[left];
                left++;
                pos--;
            }
            else{
                ans[pos] = nums[right] * nums[right];
                right--;
                pos--;
            }
        }
        return ans;
    }
}