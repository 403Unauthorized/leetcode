// 剑指 Offer 30. 包含min函数的栈 - Easy
// https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
package pointtooffer

import "math"

type MinStack struct {
	MinVal int
	Stack  []int
	Len    int
}

/** initialize your data structure here. */
func Constructor() MinStack {
	return MinStack{Stack: make([]int, 0), MinVal: math.MaxInt32}
}

func (this *MinStack) Push(x int) {
	if x < this.MinVal {
		this.MinVal = x
	}
	this.Stack = append(this.Stack, x)
	this.Len += 1
}

func (this *MinStack) Pop() {
	this.Stack = this.Stack[:this.Len-1]
	this.Len -= 1
	this.MinVal = math.MaxInt32
	for _, v := range this.Stack {
		if v < this.MinVal {
			this.MinVal = v
		}
	}
}

func (this *MinStack) Top() int {
	return this.Stack[this.Len-1]
}

func (this *MinStack) Min() int {
	return this.MinVal
}
