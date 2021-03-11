class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int c : coins) {
            for (int j = 1; j <= amount; j++) {
                if (j >= c) {
                    dp[j] = Math.min(dp[j], dp[j - c] + 1);
                }
            }
        }
        return dp[amount] < amount + 1 ? dp[amount] : -1;
    }
}
