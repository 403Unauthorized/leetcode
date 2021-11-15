# 11. 盛最多水的容器
# https://leetcode-cn.com/problems/container-with-most-water/

from typing import List


class Solution:
    def maxArea(self, height: List[int]) -> int:
        size = len(height)
        if size < 2: return 0
        left, right, ans = 0, size - 1, 0
        while left < right:
            area = (right - left) * min(height[left], height[right])
            ans = max(ans, area)
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return ans