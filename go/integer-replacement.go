// 397. 整数替换 - Medium
// https://leetcode-cn.com/problems/integer-replacement/
package leetcode

func integerReplacement(n int) int {
	return dfs(n, 0)
}

func dfs(n int, replace int) int {
	if n == 1 {
		return replace
	}

	if n%2 == 0 {
		return dfs(n, replace+1)
	} else {
		plusOne := dfs(n+1, replace+1)
		minusOne := dfs(n-1, replace+1)
		return min(plusOne, minusOne)
	}
}
