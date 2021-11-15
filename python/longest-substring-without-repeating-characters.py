

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l, left, ans = len(s), 0, 0
        dic = {}
        for i in range(l):
            if s[i] in dic:
                left = max(left, dic[s[i]] + 1)
            dic[s[i]] = i
            ans = max(ans, i - left + 1)
        return ans