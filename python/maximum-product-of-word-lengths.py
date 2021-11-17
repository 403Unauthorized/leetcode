# 318. 最大单词长度乘积 - Medium
# https://leetcode-cn.com/problems/maximum-product-of-word-lengths/

from typing import List
from itertools import product
from functools import reduce


def maxProduct(words: List[str]) -> int:
    mask = [reduce(lambda a, b : (a | 1 << (ord(b) - ord('a'))), word, 0) for word in words]
    return max(len(x[1]) * len(y[1]) for x, y in product(zip(mask, words)) if x[0] & y[0] == 0, default=0)