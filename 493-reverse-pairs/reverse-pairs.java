class Solution {
    public int reversePairs(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        int n = arr.length;
 
        // Arrays with fewer than two values cannot form a pair.
        if (n < 2) {
            return 0;
        }
 
        return mergeSort(arr, 0, n - 1);
    }
 
    // Counts reverse pairs while sorting the selected range.
    private int mergeSort(int[] arr, int left, int right) {
        // A range with zero or one value cannot contain a pair.
        if (left >= right) {
            return 0;
        }
 
        int mid = left + (right - left) / 2;
        int pairs = 0;
 
        pairs += mergeSort(arr, left, mid);
        pairs += mergeSort(arr, mid + 1, right);
        pairs += countCrossPairs(arr, left, mid, right);
        mergeSortedHalves(arr, left, mid, right);
 
        return pairs;
    }
 
    // Returns cross pairs from the left half to the right half.
    private int countCrossPairs(int[] arr, int left, int mid, int right) {
        int pairs = 0;
        int rightPointer = mid + 1;
 
        // Count how many right-half values are valid for each left-half value.
        for (int leftPointer = left; leftPointer <= mid; leftPointer++) {
            long leftValue = arr[leftPointer];
 
            // Move across right-half values that satisfy the reverse-pair condition.
            while (rightPointer <= right && leftValue > 2L * arr[rightPointer]) {
                rightPointer++;
            }
 
            pairs += rightPointer - (mid + 1);
        }
 
        return pairs;
    }
 
    // Merges two sorted halves into one sorted range.
    private void mergeSortedHalves(int[] arr, int left, int mid, int right) {
        int[] merged = new int[right - left + 1];
        int first = left;
        int second = mid + 1;
        int write = 0;
 
        // Merge the smaller available value from the two halves.
        while (first <= mid && second <= right) {
            // The smaller value should be placed next in the merged range.
            if (arr[first] <= arr[second]) {
                merged[write] = arr[first];
                first++;
            } else {
                merged[write] = arr[second];
                second++;
            }
            write++;
        }
 
        // Copy any remaining values from the left half.
        while (first <= mid) {
            merged[write] = arr[first];
            first++;
            write++;
        }
 
        // Copy any remaining values from the right half.
        while (second <= right) {
            merged[write] = arr[second];
            second++;
            write++;
        }
 
        // Write the merged values back into the selected range.
        for (int index = 0; index < merged.length; index++) {
            arr[left + index] = merged[index];
        }
    }
}