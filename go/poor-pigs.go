//
//
package leetcode

import "math"

func poorPigs(buckets int, minutesToDie int, minutesToTest int) int {
	times := minutesToTest / minutesToDie
	base := times + 1
	log := math.Log(float64(buckets)) / math.Log(float64(base))
	return int(math.Ceil(log))
}
