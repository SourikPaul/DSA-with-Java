class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;

        // Result array initialized to size n
        int[] ans = new int[n];

        // posIndex for even indices (positive), negIndex for odd (negative)
        int posIndex = 0, negIndex = 1;

        // Traverse input array
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                // Place negative number at odd index
                ans[negIndex] = nums[i];
                negIndex += 2;
            } else {
                // Place positive number at even index
                ans[posIndex] = nums[i];
                posIndex += 2;
            }
        }

        return ans;
    }
}