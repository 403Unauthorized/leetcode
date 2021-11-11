// 375. 猜数字大小 II - Medium
// https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/
package leetcode

import "math"

// 动态规划题
// 假设选中 [1, n] 中的k值，则下一次猜数字需要给的钱为
// max(f(1,k-1)（数字大了）,f(k+1,n)（数字小了）) + k
// 所以我们就可以列出状态转移方程：
// f(i,j) = max(dfs(i,k-1),dfs(k+1,j))+k
func getMoneyAmount(n int) int {
	dp := make([][]int, n+1)
	for i := range dp {
		dp[i] = make([]int, n+1)
	}
	for i := n - 1; i >= 1; i-- {
		for j := i + 1; j <= n; j++ {
			minCost := math.MaxInt32
			for x := i; x < j; x++ {
				cost := x + max(dp[i][x-1], dp[x+1][j])
				minCost = min(cost, minCost)
			}
			dp[i][j] = minCost
		}
	}
	return dp[1][n]
}

func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func min(a int, b int) int {
	if a < b {
		return a
	} else {
		return b
	}
}
