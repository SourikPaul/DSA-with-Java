class Solution {
    public int mySqrt(int x) {
        int low = 0; 
        int high = x;
        while (low <= high){
            long mid = low + (high - low) / 2;
            long ans = mid * mid;
            if (ans <= x){
                low = (int) mid + 1;
            }
            else {
                high = (int) mid - 1;
            }
        }
        return high;
    }
}