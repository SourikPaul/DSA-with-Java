class Solution {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> preCount = new HashMap<>();

        preCount.put(0, 1);

        int preSum = 0;
        int count = 0;

        for (int value : nums) {

            preSum += value;

            int sum = preSum - k;

            if (preCount.containsKey(sum)) {
                count += preCount.get(sum);
            }

            preCount.put(preSum, preCount.getOrDefault(preSum, 0) + 1);
        }

        return count;
    }
}