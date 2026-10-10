class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 1;
        for (int i = 0; i < nums.length; i++){
            high = Math.max(high, nums[i]);
        }
        while (low <= high){
            int mid = low + (high - low) / 2;
            int sum = calSum(nums, mid);
            if (sum <= threshold){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;

    }
    public int calSum(int[] nums, int div){
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum += (nums[i] + div - 1) / div;
        }
        return sum;
    }
}