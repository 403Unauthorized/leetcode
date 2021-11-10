// 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数 - Easy
// https://leetcode-cn.com/problems/w3tCBm/
// https://leetcode-cn.com/problems/counting-bits/
package main

func countOne(x int) (one int) {
	for ; x > 0; x &= x - 1 {
		one++
	}
	return one
}

func countBits(n int) []int {
	bits := make([]int, n+1)
	for i := range bits {
		bits[i] = countOne(i)
	}
	return bits
}
