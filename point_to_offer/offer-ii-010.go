// 剑指 Offer II 010. 和为 k 的子数组 - Medium
// https://leetcode-cn.com/problems/QTMn0o/
package pointtooffer

// 这里想要用到滑动窗口的思想，但是看到题目的要求中数组的元素会有负数
// 这样的话就不符合滑动窗口的方案了，所以只能用到HashTable + 前缀和了
func subarraySum(nums []int, k int) int {
	dict := make(map[int]int)
	sum, ans := 0, 0
	for i := range nums {
		sum += nums[i]
		if _, ok := dict[sum-k]; ok {
			ans += dict[sum-k]
		}
		if _, ok := dict[sum]; ok {
			dict[sum] = dict[sum] + 1
		} else {
			dict[sum] = 1
		}
	}
	return ans
}
