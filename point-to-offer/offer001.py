# https://leetcode-cn.com/problems/xoh6Oh/
class Solution:
    def divide(self, a: int, b: int) -> int:
        INT_MAX = (1 << 31) - 1
        ans = 0
        neg = not (a < 0 and b < 0) and (a < 0 or b < 0)
        a, b = abs(a), abs(b)
        if a == b: return -1 if neg else 1
        for i in range(31, -1, -1):
            if b << i <= a:
                a -= b << i
                ans += 1 << i
        ans = ans if not neg else -1 * ans
        return INT_MAX if ans > INT_MAX else ans
    
