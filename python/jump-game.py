# 55. 跳跃游戏
# https://leetcode-cn.com/problems/jump-game/

from typing import List


def canJump(nums: List[int]) -> bool:
    maxIdx = 0
    for i, n in enumerate(nums):
        if i <= maxIdx:
            maxIdx = max(maxIdx, i + nums[i])
    return maxIdx >= i