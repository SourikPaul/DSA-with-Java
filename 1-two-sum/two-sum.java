class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap <Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length; i++){
            int current = nums[i];
            int needed = target - current;
            if (map.containsKey(needed)){
                return new int[] {map.get(needed), i};
            }
            map.put(current, i);
        }
        return new int[] {};
    }
}