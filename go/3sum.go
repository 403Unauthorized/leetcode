package leetcode

import "sort"

func threeSum(nums []int) [][]int {
	var ans [][]int
	n := len(nums)
	if n < 3 {
		return ans
	}
	sort.Ints(nums)
	for i := 0; i < n-2; i++ {
		if nums[i] > 0 {
			return ans
		}
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		j, k := i+1, n-1
		for j < k {
			sum := nums[i] + nums[j] + nums[k]
			if sum > 0 {
				k--
				for j < k && nums[k] == nums[k+1] {
					k--
				}
			} else if sum < 0 {
				j++
				for j < k && nums[j] == nums[j-1] {
					j++
				}
			} else {
				ans = append(ans, []int{nums[i], nums[j], nums[k]})
				j++
				k--
				for j < k && nums[j] == nums[j-1] {
					j++
				}
				for j < k && nums[k] == nums[k+1] {
					k--
				}
			}
		}
	}
	return ans
}
