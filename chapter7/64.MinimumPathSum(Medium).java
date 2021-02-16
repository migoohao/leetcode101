import java.util.Arrays;

class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length + 1];
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                dp[col + 1] = Math.min(dp[col], dp[col + 1]) + grid[row][col];
            }
            dp[0] = Integer.MAX_VALUE;
        }
        return dp[dp.length - 1];
    }
}