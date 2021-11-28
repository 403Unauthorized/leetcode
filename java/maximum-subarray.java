package java;

class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sub = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sub += nums[i];
            if (nums[i] > sub) {
                sub = nums[i];
            }
            max = Math.max(max, sub);
        }
        return max;
    }
}
