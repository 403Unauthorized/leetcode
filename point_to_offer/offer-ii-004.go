// 剑指 Offer II 004. 只出现一次的数字 - Medium
// https://leetcode-cn.com/problems/WGki4K/
package pointtooffer

func singleNumber(nums []int) int {
	dict := make(map[int]int)
	for _, v := range nums {
		if _, ok := dict[v]; ok {
			dict[v]++
		} else {
			dict[v] = 1
		}
	}
	for k, v := range dict {
		if v == 1 {
			return k
		}
	}
	return -1
}
