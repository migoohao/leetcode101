class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        if (s1.length < s2.length) {
            char[] tmp = s1;
            s1 = s2;
            s2 = tmp;
        }
        int[][]dp = new int[2][s2.length + 1];
        for(int i = 0; i < s1.length; i++) {
            for(int j = 0; j< s2.length; j++) {
                if (s1[i] == s2[j]) {
                    dp[(i + 1) % 2][j + 1] = dp[i % 2][j] + 1;
                } else {
                    dp[(i + 1) % 2][j + 1] = Math.max(dp[(i + 1) % 2][j], dp[i % 2][j + 1]);
                }
            }
        }
        return dp[(s1.length) % 2][s2.length];
    }
}
