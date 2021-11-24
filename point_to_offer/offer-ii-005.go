// 剑指 Offer II 005. 单词长度的最大乘积 - Medium
// https://leetcode-cn.com/problems/aseY1I/
package pointtooffer

func maxProduct(words []string) int {
	mask := make([]int, len(words))
	for i, s := range words {
		var bitMask int = 0
		for _, c := range s {
			bitMask |= (1 << (c - 'a'))
		}
		mask[i] = bitMask
	}
	ans := 0
	for i := 0; i < len(mask); i++ {
		for j := i + 1; j < len(mask); j++ {
			if mask[i]&mask[j] == 0 {
				ans = max(ans, len(words[i])*len(words[j]))
			}
		}
	}
	return ans
}

func max(a int, b int) int {
	if a > b {
		return a
	}
	return b
}
