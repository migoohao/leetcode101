class Solution {
    public int minDistance(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int[][] dp = new int[c1.length + 1][c2.length + 1];
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                int pre = Math.min(dp[i][j + 1], dp[i + 1][j]) + 1;
                if (c1[i] == c2[j]) {
                    dp[i + 1][j + 1] = Math.min(pre, dp[i][j]);
                } else {
                    dp[i + 1][j + 1] = Math.min(pre, dp[i][j] + 1);
                }
            }
        }
        return dp[c1.length][c2.length];
    }
}
