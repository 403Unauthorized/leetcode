# 123. 买卖股票的最佳时机 III - Hard
# https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/

from typing import List


def maxProfit(prices: List[int]) -> int:
    buy1, sell1 = -prices[0], 0
    buy2, sell2 = -prices[0], 0
    for p in prices:
        buy1 = max(buy1, -p)
        sell1 = max(sell1, buy1 + p)
        buy2 = max(buy2, sell1 - p)
        sell2 = max(sell2, buy2 + p)
    return sell2