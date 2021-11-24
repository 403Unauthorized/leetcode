# 剑指 Offer II 007. 数组中和为 0 的三个数 - Medium
# https://leetcode-cn.com/problems/1fGaJU/

from typing import List


def threeSum(nums: List[int]) -> List[List[int]]:
    if len(nums) < 3:
        return []
    nums.sort()
    ans = []
    for i in range(len(nums) - 1):
        if nums[i] > 0:
            break
        if i > 0 and nums[i] == nums[i - 1]:
            continue
        left, right = i + 1, len(nums) - 1
        while left < right:
            summary = nums[i] + nums[left] + nums[right]
            if summary > 0:
                right -= 1
                while left < right and nums[right + 1] == nums[right]:
                    right -= 1
            elif summary < 0:
                left += 1
                while left < right and nums[left - 1] == nums[left]:
                    left += 1
            else:
                ans.append([nums[i], nums[left], nums[right]])
                left += 1
                right -= 1
                while left < right and nums[left - 1] == nums[left]:
                    left += 1
                while left < right and nums[right + 1] == nums[right]:
                    right -= 1
    return ans