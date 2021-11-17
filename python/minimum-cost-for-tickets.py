# 983. 最低票价 - Medium
# https://leetcode-cn.com/problems/minimum-cost-for-tickets

from typing import List

# 从后往前的动态规划
# 创建一个dp数组，长度为最后一天加31
# 从最后一天开始向前遍历
# if 第i天需要出行
#   dp[i] = min(dp[i + 1] + costs[0], dp[i + 7] + costs[1], dp[i + 30] + costs[2])
# else (第i天不需要出行)
#   dp[i] = dp[i + 1]
# 最佳票价就是 dp[firstDay]，出行的那一天
def mincostTicket(days: List[int], costs: List[int]) -> int:
    lastDay, firstDay = days[-1], days[0]
    daySet = set(days)
    dp = [0] * (lastDay + 31)
    for i in range(lastDay, firstDay - 1, -1):
        if i in daySet:
            dp[i] = min(dp[i + 1] + costs[0], dp[i + 7] + costs[1], dp[i + 30] + costs[2])
        else:
            dp[i] = dp[i + 1]
    return dp[firstDay - 1]