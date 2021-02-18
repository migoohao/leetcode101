class Solution {
    private static final int[] roots = new int[100];
    static {
        for (int i = 0; i < 100; i++) {
            roots[i] = (i + 1) * (i + 1);
        }
    }
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1, dp.length, Integer.MAX_VALUE);
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < roots.length && roots[j] <= i; j++) {
                dp[i] = Math.min(dp[i - roots[j]] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}
