class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = position[position.length - 1] - position[0];
        int ans = -1;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (canPlace(position, m, mid)){
                ans = mid;
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }
        return ans; 
    }

    private boolean canPlace(int[] position, int m, int dist){
        int ballsPlaced = 1;
        int lastPosition = position[0];
        for(int i = 1; i < position.length; i++){ 
            if (position[i] - lastPosition >= dist){
                ballsPlaced++;
                lastPosition = position[i];
                if(ballsPlaced == m){
                    return true;
                }

            }
        }
        return false;
    }
}