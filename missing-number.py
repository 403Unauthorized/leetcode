# 268. 消失的数字 - Easy

from typing import List
class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        ans = 0
        for i in range(n + 1):
            ans ^= i
        for num in nums:
            ans ^= num
        return ans
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        total = (1 + n) * n >> 1
        numsTotal = 0
        for num in nums:
            numsTotal += num
        return total - numsTotal