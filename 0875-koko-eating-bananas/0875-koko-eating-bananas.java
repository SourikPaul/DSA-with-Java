class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for ( int i = 0; i < piles.length; i++){
            high = Math.max(high, piles[i]);
        }
        while (low < high) {
            int mid = low + (high - low ) / 2;
            if (canFinish(piles, h, mid)){
                high = mid;
            } else{
                low = mid + 1;
            }
        }
        return low;
    }

    private boolean canFinish(int[] piles, int h, int speed){
        long hours = 0;
        for (int i = 0; i < piles.length; i++){
            hours += (piles[i] + speed - 1) / speed;
            if (hours > h) {
                return false;
            }
        }
        return true;
    }
}