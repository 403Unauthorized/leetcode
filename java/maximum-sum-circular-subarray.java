// 918. 环形子数组的最大和
// https://leetcode-cn.com/problems/maximum-sum-circular-subarray/
package java;

class MaximumSumCircularSubarray {
    /**
     * 这道题最基本的思路就是求出最大子序和和最小子序和
     * 如果最大子序和大于零，则返回(整个数组和 - 最小子序和) 和 最大子序和 中较大的一个值
     * 如果最大子序和小于零，则直接返回最大子序和
     */
    public int maxSubarraySumCircular(int[] nums) {
        int min = 0, max = Integer.MIN_VALUE;
        int subMin = 0, subMax = 0;
        int arraySum = 0;
        for (int i = 0; i < nums.length; i++) {
            arraySum += nums[i];
            subMin += nums[i];
            subMax += nums[i];
            if (nums[i] < subMin) {
                subMin = nums[i];
            }
            if (nums[i] > subMax) {
                subMax = nums[i];
            }
            min = Math.min(min, subMin);
            max = Math.max(max, subMax);
        }
        return max > 0 ? Math.max(max, arraySum - min) : max;
    }
}
