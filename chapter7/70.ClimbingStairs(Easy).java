class Solution {
    private static int[] dp = new int[46];
    static {
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
    }

    public int climbStairs(int n) {
        return dp[n];
    }
}
