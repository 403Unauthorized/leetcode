#
#
import math

def getMoneyAmount(n: int) -> int:
    def dfs(x: int, y: int) -> int:
        return min(max(dfs(x, k - 1), dfs(k + 1, y)) + k for k in range(x, y + 1)) if y > x else 0
    return dfs(1, n)