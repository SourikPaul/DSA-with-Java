class Solution {
    /*
    Checks whether the target exists
    anywhere in the rotated array.
    */
    public boolean search(int[] nums, int target) {
        // Left boundary of the current search range.
        int low = 0;
 
        // Right boundary of the current search range.
        int high = nums.length - 1;
 
        // Keep searching while a valid range still exists.
        while (low <= high) {
            // Calculate the middle index safely.
            int mid = low + (high - low) / 2;
 
            // The target is found at the middle position.
            if (nums[mid] == target) {
                return true;
            }
 
            // Duplicates at both ends hide which half is sorted.
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }
            // The left half is normally sorted.
            else if (nums[low] <= nums[mid]) {
                // The target lies inside the sorted left half.
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    // The target must lie in the other half.
                    low = mid + 1;
                }
            } else {
                // The right half must be normally sorted here.
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    // The target must lie in the other half.
                    high = mid - 1;
                }
            }
        }
 
        return false;
    }
}    