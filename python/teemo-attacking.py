# 495. 提莫攻击
# https://leetcode-cn.com/problems/teemo-attacking/
import json
from os import times
from typing import List

def findPoisonedDuration(timeSeries: List[int], duration: int) -> int:
    if duration == 0:
        return 0
    ans = duration
    size = len(timeSeries)
    if size > 1:
        for i in range(1, size):
            if timeSeries[i] - timeSeries[i - 1] < duration:
                ans += timeSeries[i] - timeSeries[i - 1]
            else:
                ans += duration
    else:
        return ans
    return ans