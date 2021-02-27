class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = binarySearchFirstLower(dp, size, nums[i]) + 1;
            size = Math.max(size, index + 1);
            dp[index] = Math.min(dp[index], nums[i]);
        }
        return size;
    }
    private int binarySearchFirstLower(int[] arr, int size, int target) {
        int start = 0;
        int end = size;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] < target) {
                start = mid + 1;
            } else if (arr[mid] > target) {
                end = mid;
            } else {
                start = mid;
                break;
            }
        }
        return (start == end || arr[start] >= target) ? start - 1 : start;
    }
}
