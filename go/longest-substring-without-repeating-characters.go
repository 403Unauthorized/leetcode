// 3. 无重复字符的最长子串
// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
package leetcode

func lengthOfLongestSubstring(s string) int {
	l, left, ans := len(s), 0, 0
	dict := make(map[rune]int)
	for i := 0; i < l; i++ {
		if _, ok := dict[rune(s[i])]; ok {
			left = max(left, dict[rune(s[i])]+1)
		}
		dict[rune(s[i])] = i
		ans = max(ans, i-left+1)
	}
	return ans
}
