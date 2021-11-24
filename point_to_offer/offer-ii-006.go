// 剑指 Offer II 006. 排序数组中两个数字之和 - Easy
// https://leetcode-cn.com/problems/kLl5u1/
package pointtooffer

func twoSum(numbers []int, target int) []int {
	dict := make(map[int]int)
	for i, v := range numbers {
		if _, ok := dict[target-v]; ok {
			return []int{dict[target-v], i}
		} else {
			dict[v] = i
		}
	}
	return []int{}
}
