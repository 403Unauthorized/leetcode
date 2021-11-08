# 96. 不同的二叉搜索树 - Medium
# https://leetcode-cn.com/problems/unique-binary-search-trees/
# 思路：
#   从1到n遍历每一个数字在根结点
#   F(i, n) = G(i - 1) * G(n - i)
#   长度为n的树以i为根结点的二叉搜索树个数 = 1 到 i - 1能构建的左子树的个数 * i + 1 到 n能构建的右子树的个数
#   
#   这个公式在数学上被称为卡塔兰数
#   C0 = 1, C(n + 1) = ((2*(2*n+1))/(n+2))C(n)
#

class Solution:
    def numTrees(self, n: int) -> int:
        C = 1
        for i in range(0, n):
            C = C * 2 * (2 * i + 1) / (i + 2)
        return int(C)