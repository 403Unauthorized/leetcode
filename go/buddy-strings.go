// 859. 亲密字符串 - Easy
// https://leetcode-cn.com/problems/buddy-strings/
package leetcode

func buddyStrings(s string, goal string) bool {
	if len(s) != len(goal) {
		return false
	}
	// 当s和goal相等时，只要有字符重复，他们就是亲密字符串
	// 如果s或者goal中没有重复的字符，他们就不是亲密字符串
	if s == goal {
		valid := [26]bool{}
		for _, ch := range s {
			if valid[ch-'a'] {
				return true
			}
			valid[ch-'a'] = true
		}
		return false
	}
	// s和goal不相等时，大于两个不相等的字符时，就不为亲密字符串
	first, second := -1, -1
	for i := 0; i < len(s); i++ {
		if s[i] != goal[i] {
			if first == -1 {
				first = i
			} else if second == -1 {
				second = i
			} else {
				return false
			}
		}
	}
	// 所以当second不等于-1且两个位置字符串能互换时，就为亲密字符串
	return second != -1 && s[first] == goal[second] && s[second] == goal[first]
}
