class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            for (String word : wordDict) {
                int start = i - word.length() + 1;
                if (start >= 0 && dp[start] && s.substring(start, i + 1).equals(word)) {
                    dp[i+1] = true;
                    break;
                }
            }
        }
        dp[0] = false;
        return dp[dp.length - 1];
    }
}