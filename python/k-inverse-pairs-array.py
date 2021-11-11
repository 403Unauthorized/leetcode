# 629. K个逆序对数组 - Hard
# https://leetcode-cn.com/problems/k-inverse-pairs-array/

def kInversePairs(n: int, k: int) -> int:
    mod = int(1e9) + 7
    f = [1] + [0] * k
    for i in range(1, n + 1):
        g = [0] * (k + 1)
        for j in range(k + 1):
            g[j] = (g[j - 1] if j - 1 >= 0 else 0) - (f[j - i] if j - i >= 0 else 0) + f[j]
            g[j] %= mod
        f = g
    return f[k]
