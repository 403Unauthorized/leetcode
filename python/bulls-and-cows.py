# 299. 猜数字游戏 - Medium
# https://leetcode-cn.com/problems/bulls-and-cows/

class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        d = dict()
        for s in secret:
            if s not in d.keys():
                d[s] = 1
            else:
                d[s] += 1
        guessLen = len(guess)
        a, b = 0, 0
        for i in range(guessLen):
            if guess[i] == secret[i]:
                d[guess[i]] -= 1
                a += 1
        for i in range(guessLen):
            if guess[i] == secret[i]:
                continue
            if guess[i] in d.keys() and d[guess[i]] > 0:
                b += 1
                d[guess[i]] -= 1
        return f'{a}A{b}B'