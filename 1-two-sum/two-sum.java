import java.util.Arrays;

class Solution {

    public int[] twoSum(int[] arr, int target) {

        int n = arr.length;
        int[][] numsWithIndex = new int[n][2];

        for (int i = 0; i < n; i++) {
            numsWithIndex[i][0] = arr[i];
            numsWithIndex[i][1] = i;
        }

        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0;
        int right = n - 1;

        while (left < right) {

            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];

            if (sum == target) {
                return new int[] {
                    numsWithIndex[left][1],
                    numsWithIndex[right][1]
                };
            }
            else if (sum < target) {
                left++;
            }
            else {
                right--;
            }
        }

        return new int[] {-1, -1};
    }
}