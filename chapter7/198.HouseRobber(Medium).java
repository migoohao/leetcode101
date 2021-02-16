class Solution {
    public int rob(int[] nums) {
        int previous = 0;
        int beforePrevious = 0;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            current = Math.max(previous, beforePrevious + nums[i]);
            beforePrevious = previous;
            previous = current;
        }
        return current;
    }
}