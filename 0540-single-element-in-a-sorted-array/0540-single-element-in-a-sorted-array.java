class Solution {

    public int singleNonDuplicate(int[] nums) {

        int low = 0;
 
        // Right boundary of the current search range.
        int high = nums.length - 1;
 
        // Keep shrinking the range until only one position remains.
        while (low < high) {
            // Calculate the middle index safely.
            int mid = low + (high - low) / 2;
 
            // Move to the first index of the expected pair.
            if (mid % 2 == 1) {
                mid--;
            }
 
            // A proper pair means the single element is further right.
            if (nums[mid] == nums[mid + 1]) {
                low = mid + 2;
            } else {
                // The broken pair means the answer is at mid or to the left.
                high = mid;
            }
        }
 
        return nums[low];
    }
}