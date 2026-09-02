class Solution {
    public boolean uniformArray(int[] nums1) {
        int oddCount = 0;
        for(int i = 0; i < nums1.length; i++){
            if(nums1[i] % 2 == 1){
                oddCount++;
            }
        }
        return true;
    }
}