// 322. 零钱兑换 - Medium
// https://leetcode-cn.com/problems/coin-change/
package leetcode

import "math"

func coinChange(coins []int, amount int) int {
	dp := make([]int, amount+1)
	for i := range dp {
		dp[i] = math.MaxInt32
	}
	dp[0] = 0

	for i, _ := range dp {
		for _, c := range coins {
			if i-c < 0 {
				continue
			}
			dp[i] = min(dp[i], 1+dp[i-c])
		}
	}
	if dp[amount] == math.MaxInt32 {
		return -1
	}
	return dp[amount]
}
