class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[] ones = new int[strs.length];
        int[] zeros = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            for (char c : chars) {
                if (c == '1') {
                    ones[i]++;
                } else {
                    zeros[i]++;
                }
            }
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            for (int j = m; j >= 0; j--) {
                for (int k = n; k >= 0; k--) {
                    if (j - zeros[i] >= 0 && k - ones[i] >= 0) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - zeros[i]][k - ones[i]] + 1);
                    }
                }
            }
        }
        return dp[m][n];
    }
}

