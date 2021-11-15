// 3. 盛水最多的容器 - Medium
// https://leetcode-cn.com/problems/container-with-most-water/
package leetcode

func maxArea(height []int) int {
	size := len(height)
	left, right := 0, size-1
	ans := 0
	for left < right {
		area := (right - left) * min(height[left], height[right])
		ans = max(ans, area)
		if height[left] < height[right] {
			left += 1
		} else {
			right += 1
		}
	}
	return ans
}
