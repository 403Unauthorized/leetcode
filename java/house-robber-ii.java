// 213. 打家劫舍 II - Medium
// https://leetcode-cn.com/problems/house-robber-ii/
package java;

class HouseRobber2 {
    /**
     * 分别计算抢第一家不抢最后一家的最大值和不抢第一家抢最后一家的最大值
     * 算出来两个最大值取较大的值返回
     */
    public int rob(int[] nums) {
        int pre1 = 0;
        int max1 = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            int temp = pre1;
            pre1 = max1;
            max1 = Math.max(max1, nums[i] + temp);
        }
        int pre2 = 0;
        int max2 = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 1; i--) {
            int temp = pre2;
            pre2 = max2;
            max2 = Math.max(max2, nums[i] + temp);
        }
        return Math.max(max1, max2);
    }
}
