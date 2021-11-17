// 55. 跳跃游戏
// https://leetcode-cn.com/problems/jump-game/
package java;

class JumpGame {
    /**
     * 遍历input数组，将每个数字能跳到的最大下标 maxIdx 记录下来
     * 如果当前遍历到的数字下表小于或者等于 maxIdx，
     * 继续比较当前位置能跳到的最大下标与 maxIdx
     * 如果当前位置能跳到的最大下标大于 maxIdx，则将这个最大下标记录为 maxIdx
     * 遍历完之后如果 maxIdx 大于或者等于 nums.length - 1，
     * 则说明能跳到最后一个下标
     * @param nums
     * @return 是否能跳到最后一个下标
     */
    public boolean canJump(int[] nums) {
        int maxIdx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxIdx) {
                maxIdx = Math.max(maxIdx, i + nums[i]);
            }
        }
        return maxIdx >= nums.length - 1;
    }
}
