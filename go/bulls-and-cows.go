// 299. 猜数字游戏 - Medium
// https://leetcode-cn.com/problems/bulls-and-cows/
package leetcode

import "fmt"

func getHint(secret string, guess string) string {
	var d map[rune]int = make(map[rune]int)
	for _, v := range secret {
		if _, ok := d[v]; ok {
			d[v] += 1
		} else {
			d[v] = 1
		}
	}
	a, b := 0, 0
	for i, v := range guess {
		if v == rune(secret[i]) {
			a++
			d[v]--
		}
	}
	for i, v := range guess {
		if v == rune(secret[i]) {
			continue
		}
		if _, ok := d[v]; ok && d[v] > 0 {
			b++
			d[v]--
		}
	}
	return fmt.Sprintf("%dA%dB", a, b)
}
