class Solution {  
    public int[] rowAndMaximumOnes(int[][] mat) {

        int maxCount = 0;
        int answer = 0;
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                answer = i;
            }
        }
        return new int[]{answer, maxCount};
    }
}