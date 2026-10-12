class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int low = bloomDay[0];
        int high = bloomDay[0];
        for (int i = 0; i < n; i++){
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);
        }
        int ans = -1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (canMakeBouquets(bloomDay, mid, m, k)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return ans;
    }
    private boolean canMakeBouquets(int[] bloomDay, int day, int m, int k){
        int conse = 0;
        int bouquets = 0;
        for (int i = 0; i < bloomDay.length; i++){
            if (bloomDay[i] <= day){
                conse++;

            } else {
                bouquets += (conse / k);
                conse = 0;
            }
        }
        bouquets += (conse / k);
        return bouquets >= m;
    }
}