// 122. 买卖股票的最佳时机 II - Medium
// https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
package java;

class SellStock2 {
    /**
     * 考虑两种情况：
     * 1. 股票连续上涨时：maxProfit = (prices[2] - prices[1]) + (prices[3] - prices[2]) + ... + (prices[i] - prices[i - 1])
     * 2. 股票下跌时：即 prices[i] - prices[i - 1] < 0，不操作
     * 3. 当股票下跌后又上涨了： maxProfit += prices[i] - prices[i - 1]
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 贪心的假设每天都有交易
            int profit = prices[i] - prices[i - 1];
            // 如果此次交易的profit大于0
            if (profit > 0) {
                // 将此次交易的profit叠加到maxProfit里面
                maxProfit += profit;
            }
        }
        return maxProfit;
    }
}
