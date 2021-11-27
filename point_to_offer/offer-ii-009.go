// 剑指 Offer II 009. 乘积小于 K 的子数组 - Medium
// https://leetcode-cn.com/problems/ZVAVXX/
package pointtooffer

// 这里我使用了滑动窗口来解决这个问题，效率比较低
// 时间复杂度是 O(n!)
func numSubarrayProductLessThanK(nums []int, k int) int {
	total, ans := 1, 0
	for left := 0; left < len(nums); left++ {
		right := left + 1
		total *= nums[left]
		if total < k {
			ans++
		}
		for right < len(nums) {
			total *= nums[right]
			right++
			if total < k {
				ans++
			} else {
				break
			}
		}
		total = 1
	}
	return ans
}
