// 384. 打乱数组 - Medium
// https://leetcode-cn.com/problems/shuffle-an-array/
package leetcode

import "math/rand"

type Solution struct {
	nums, original []int
}

func Constructor(nums []int) Solution {
	return Solution{nums, append([]int(nil), nums...)}
}

func (this *Solution) Reset() []int {
	copy(this.nums, this.original)
	return this.nums
}

func (this *Solution) Shuffle() []int {
	n := len(this.nums)
	for i := range this.nums {
		target := i + rand.Intn(n-i)
		this.nums[i], this.nums[target] = this.nums[target], this.nums[i]
	}
	return this.nums
}
