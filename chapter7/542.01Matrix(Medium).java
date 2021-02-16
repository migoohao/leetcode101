class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != 0) {
                    int distant = Integer.MAX_VALUE / 2;
                    if (row > 0) {
                        distant = Math.min(distant, dp[row - 1][col] + 1);
                    }
                    if (col > 0) {
                        distant = Math.min(distant, dp[row][col - 1] + 1);
                    }
                    dp[row][col] = distant;
                }
            }
        }
        for (int row = dp.length - 1; row >= 0; row--) {
            for (int col = dp[row].length - 1; col >= 0; col--) {
                if (matrix[row][col] != 0) {
                    int distant = Integer.MAX_VALUE / 2;
                    if (row < dp.length - 1) {
                        distant = Math.min(distant, dp[row + 1][col] + 1);
                    }
                    if (col < dp[row].length - 1) {
                        distant = Math.min(distant, dp[row][col + 1] + 1);
                    }
                    dp[row][col] = Math.min(distant, dp[row][col]);
                }
            }
        }
        return dp;
    }
}