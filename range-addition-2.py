# 598. 范围求和 2 - Easy

from typing import List


class Solution:
    def maxCount(self, m: int, n: int, ops: List[List[int]]) -> int:
        # ops中元素个数为0时
        if len(ops) == 0:
            return m * n
        pre = [0, 0]
        maxCount = 0
        for op in ops:
            if pre[0] == 0 or pre[1] == 0:
                maxCount = op[0] * op[1]
                pre = op
                continue
            row, col = 0, 0
            if op[0] < pre[0]:
                row = op[0]
                pre[0] = op[0]
            else:
                row = pre[0]
            if op[1] < pre[1]:
                col = op[1]
                pre[1] = op[1]
            else:
                col = pre[1]
            maxCount = row * col
        return maxCount