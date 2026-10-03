class Solution {
    public int maxProduct(int[] nums) {

        long currentMax = nums[0];
        long currentMin = nums[0];
        long maxProduct = nums[0];

        for (int i = 1; i < nums.length; i++) {

            long currentValue = nums[i];

            long previousMax = currentMax;
            long previousMin = currentMin;

            currentMax = Math.max(
                currentValue,
                Math.max(
                    previousMax * currentValue,
                    previousMin * currentValue
                )
            );

            currentMin = Math.min(
                currentValue,
                Math.min(
                    previousMax * currentValue,
                    previousMin * currentValue
                )
            );

            maxProduct = Math.max(maxProduct, currentMax);
        }

        return (int) maxProduct;
    }
}