# 剑指 Offer II 002. 二进制加法 - easy
# https://leetcode-cn.com/problems/JFETK5/
# https://leetcode-cn.com/problems/add-binary/
import math
class Solution:
    def addBinary(self, a: str, b: str) -> str:
        ans = ""
        a, b = a[::-1], b[::-1]
        al, bl = len(a), len(b)
        i, c = 0, 0
        while i < al and i < bl:
            n1 = a[i]
            n2 = b[i]
            sum = int(n1) + int(n2) + c
            c = math.floor(sum / 2)
            ans += str(sum % 2)
            i += 1
        while i < al:
            sum = int(a[i]) + c
            c = math.floor(sum / 2)
            ans += str(sum % 2)
            i += 1
        while i < bl:
            sum = int(b[i]) + c
            c = math.floor(sum / 2)
            ans += str(sum % 2)
            i += 1
        if c > 0:
            ans += str(c)
        return ans[::-1]
            
