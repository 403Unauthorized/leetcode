# 367. 有效的完全平方数 - Easy
# https://leetcode-cn.com/problems/valid-perfect-square/

def isPerfectSquare(num: int) -> bool:
    """
    If a number is perfect square number, then it can be subtracted by 1, 3, 5, 7...
    Util the value of the number is 0
    """
    sub = 1
    while num > 0:
        num -= sub
        sub += 2
    return num == 0