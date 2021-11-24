package point_to_offer;

class Offer2_008 {

    /**
     * 这道题可以用二分查找以及前缀和来解决
     * 也可以用滑动窗口
     */
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, total = 0;
        int ans = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            total += right;
            while (total >= target) {
                ans = Math.min(ans, right - left + 1);
                total -= nums[left];
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    
}
