
// 152. 乘积最大子数组 - Medium
// https://leetcode-cn.com/problems/maximum-product-subarray/
package java;

class MaximumProductSubarray {
    // 需要记录最大和最小值，因为会有负数，如果最小值不为负数，则肯定与最大值相等
    // 当下一个数是负数时，则将最小值与最大值交换，这样最小值（为负数时）乘一个负数就会为正数且为最大
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return 0;
        }
        int maxProduct = Integer.MIN_VALUE;
        int imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(nums[i], nums[i] * imax);
            imin = Math.min(nums[i], nums[i] * imin);

            maxProduct = Math.max(maxProduct, imax);
        }
        return maxProduct;
    }
}
