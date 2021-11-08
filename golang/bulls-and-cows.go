// 299. 猜数字游戏 - Medium
package leetcode

func getHint(secret string, guess string) string {
	var d map[rune]int = make(map[rune]int)
	for _, v := range secret {
		if _, ok := d[v]; ok {
			d[v] += 1
		} else {
			d[v] = 1
		}
	}
	return ""
}
