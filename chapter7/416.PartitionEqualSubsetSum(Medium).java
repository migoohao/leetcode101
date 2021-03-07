class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        int dp[] = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j > 0; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] = Math.max(dp[j - nums[i]] + nums[i], dp[j]);
                }
                if (dp[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}
