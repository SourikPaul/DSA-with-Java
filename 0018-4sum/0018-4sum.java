class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> fourSum = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                Set<Long> seenValues = new HashSet<>();
                for(int k = j + 1; k < n; k++){
                    
                        long sum = (long) target - nums[i]
                                 - nums[j]
                                 - nums[k];
                        if(seenValues.contains(sum)){
                            List<Integer> quadra = new ArrayList<>();
                            quadra.add(nums[i]);
                            quadra.add(nums[j]);
                            quadra.add(nums[k]);
                            quadra.add((int)sum);
                            Collections.sort(quadra);
                            fourSum.add(quadra);
                        }
                        seenValues.add((long) nums[k]);
                    
                }
            }
        }
        return new ArrayList<>(fourSum);
    }
}