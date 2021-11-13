//
//
package leetcode

func detectCapitalUse(word string) bool {
	firstCap := false
	var pre rune
	for i, item := range word {
		if i == 0 {
			if isUpperCase(item) {
				firstCap = true
			}
			continue
		}
		if i == 1 {
			if !firstCap && isUpperCase(item) {
				return false
			}
			pre = item
		}
		if isUpperCase(item) {
			if isUpperCase(pre) {
				continue
			} else {
				return false
			}
		} else {
			if isUpperCase(pre) {
				return false
			}
		}
	}
	return true
}

func isUpperCase(c rune) bool {
	if c >= 'A' && c <= 'Z' {
		return true
	}
	return false
}
