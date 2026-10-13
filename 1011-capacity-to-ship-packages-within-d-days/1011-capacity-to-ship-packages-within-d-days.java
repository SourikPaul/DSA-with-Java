class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0; 
        int high = 0;
        for (int i = 0; i < weights.length; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        int ans = high;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (daysNeeded(weights, mid) <= days){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;

    }

    private int daysNeeded(int[] weights, int capacity){
        int days = 1;
        int currentLoad = 0;
        for (int i = 0; i < weights.length; i++){
            if (currentLoad + weights[i] > capacity){
                days++;
                currentLoad = weights[i];
            } else {
                currentLoad += weights[i];
            }
        }
        return days;
    }
}