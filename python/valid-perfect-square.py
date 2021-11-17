# 367. 有效的完全平方数 - Easy
# https://leetcode-cn.com/problems/valid-perfect-square/

def isPerfectSquare(num: int) -> bool:
    sub = 1
    while num > 0:
        num -= sub
        sub += 2
    return num == 0