class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0 && dp[j] && words.contains(s.substring(j, i + 1)); j--) {
                dp[i + 1] = true;
                break;
            }
        }
        dp[0] = false;
        return dp[dp.length - 1];
    }
}
