class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> threeSum = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            Set<Long> seenValues = new HashSet<>();
            for(int j = i + 1; j < nums.length; j++){
                long third = -((long)nums[i] + nums[j]);
                    if(seenValues.contains(third)){
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add((int)third);

                        Collections.sort(triplet);
                        threeSum.add(triplet);

                    }
                    seenValues.add((long) nums[j]);
                
            }
        }
        return new ArrayList<>(threeSum);
    }
}