# Dedicated to leetcode (Python)

> 当中的解法可能不是最优解，就当作是找做题的感觉。

# Daily Problems

| Date | Title | Difficulty | Category | Finished | Solution |
|------|-------|------------|----------|----------|----------|
|2021/11/06|[268. 消失的数字](https://leetcode-cn.com/problems/missing-number/)| Easy | 数组, 位运算 | :heavy_check_mark: | [Solution(Python)](./python/missing-number.py) |
|2021/11/07|[598. 范围求和 II](https://leetcode-cn.com/problems/range-addition-ii/)| Easy | 数组 | :heavy_check_mark: | [Solution(Python)](./python/range-addition-2.py) |
|2021/11/08|[299. 猜数字游戏](https://leetcode-cn.com/problems/bulls-and-cows/)| Medium | 数组 | :heavy_check_mark: | [Solution(Python)](./python/bulls-and-cows.py), [Solution(Go)](./go/bulls-and-cows.go) |
|2021/11/09|[488. 祖玛游戏](https://leetcode-cn.com/problems/zuma-game/)| Hard |  | TODO | [Solution(Python)](./python/zuma-game.py), [Solution(Go)](./go/zuma-game.go) |
|2021/11/10| [495. 提莫攻击](https://leetcode-cn.com/problems/teemo-attacking/) | Easy | 数组 | :heavy_check_mark: | [Solution(Python)](./python/teemo-attacking.py) |
|2021/11/11|[629. K个逆序对数组](https://leetcode-cn.com/problems/k-inverse-pairs-array/)| Hard | 序列DP, 数组 | :heavy_check_mark: | [Solution(Python)](./python/k-inverse-pairs-array.py) |
|2021/11/12|[375. 猜数字大小 II](https://leetcode-cn.com/problems/guess-number-higher-or-lower-ii/)| Medium | 动态规划 | :heavy_check_mark: | [Solution(Go)](./go/guess-number-higher-or-lower-ii.go), [Solution(Python)](/python/guess-number-higher-or-lower-ii.py) |
|2021/11/13| [520. 检测大写字母](https://leetcode-cn.com/problems/detect-capital/) | Easy | 字符串 | :heavy_check_mark: | [Solution(Go)](./go/detect-capital.go) |
|2021/11/14| [319. 灯泡开关](https://leetcode-cn.com/problems/bulb-switcher/) | Medium | 数学 | :heavy_check_mark: | [Solution(Java)](./java/bulb-switcher.java) |

# Leetcode Roadmap

| Title | Difficulty | Category | Finished | Solution |
|-------|------------|----------|----------|----------|
|[124. 二叉树中的最大路径和](https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/)| Hard | 二叉树, 后序遍历 | TODO |  |
|[105. 从前序与中序遍历序列构造二叉树](https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)| Medium | 二叉树, 中序遍历, 前序遍历 | :heavy_check_mark: | [Solution(Python)](./python/construct-binary-tree-from-preorder-and-inorder-traversal.py), [Solution(Go)](./go/construct-binary-tree-from-preorder-and-inorder-traversal.go) |
|[99. 恢复二叉搜索树](https://leetcode-cn.com/problems/recover-binary-search-tree/)| Medium | 二叉树, 中序遍历 | :heavy_check_mark: | [Solution(Python)](./python/recover-binary-search-tree.py), [Solution(Go)](./go/recover-binary-search-tree.go) |
|[96. 不同的二叉搜索树](https://leetcode-cn.com/problems/unique-binary-search-trees/)| Medium | 二叉搜索树 | :heavy_check_mark: | [Solution](./python/unique-binary-search-trees.py) |
|[104. 二叉树的最大深度](https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/)| Easy | 二叉树 | :heavy_check_mark: | [Solution(Python)](./python/maximum-depth-of-binary-tree.py), [Solution(Go)](./go/maximum-depth-of-binary-tree.go) |
|[3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)| Medium | 滑动窗口 | :heavy_check_mark: | [Solution(Java)](./java/longest-substring-without-repeating-characters.java), [Solution(Go)](./go/longest-substring-without-repeating-characters.go), [Solution(Python)](./python/longest-substring-without-repeating-characters.py) |
|[11. 盛最多水的容器](https://leetcode-cn.com/problems/container-with-most-water/)| Medium | 数组, 双指针 | :heavy_check_mark: | [Solution(Java)](./java/container-with-most-water.java), [Solution(Go)](./go/container-with-most-water.go), [Solution(Python)](./python/container-with-most-water.py) |
|[551. 学生出勤记录 I](https://leetcode-cn.com/problems/student-attendance-record-i/)| Easy | 数据结构，字符串 | :heavy_check_mark: | [Solution(Java)](./java/student-attendance-record-i.java) |

# 剑指 Offer II
| Title | Difficulty | Category | Finished | Solution |
|-------|------------|----------|----------|----------|
|[剑指 Offer II 001. 整数除法](https://leetcode-cn.com/problems/xoh6Oh/)| Easy | 位运算 | :heavy_check_mark: | [Solution(Python)](./point-to-offer/offer001.py) |
|[剑指 Offer II 002. 二进制加法](https://leetcode-cn.com/problems/JFETK5/)| Easy | 位运算, 数学, 字符串 | :heavy_check_mark: | [Solution(Python)](./point-to-offer/offer002.py) |
|[剑指 Offer II 003. 前 n 个数字二进制中 1 的个数](https://leetcode-cn.com/problems/w3tCBm/)| Easy | 位运算, 数学, 递归 | :heavy_check_mark: | [Solution(Go)](./point-to-offer/offer003.go) |

# 题解

## 629. K个逆序对数组（题解）

> Hard难度，该题为典型的序列DP类型的题

假设 `dp[i][j]` 为考虑了 `[1, i]` 前 `i` 个数字，逆序对为 `j` 的方案数


## 3. 无重复字符的最长子（题解）

> Medium 难度，使用滑动窗口可以解决

字符串的字母从左往右一个一个包括进滑动窗口，并将每个字符和其索引用Map存放起来。使用 `left` 字段记录窗口最左端。

当遇到了之前遇到过的字符，即遇到重复字符，则将此时的长度与前一次滑动窗口长度比较取大的值（ans = max(ans, i - left + 1)），并且将left索引设置为当前这次重复的字符的索引 + 1，并将该字符的索引替换成重复字符的索引（较大索引）。

知道循环结束，返回 ans 为最大不重复子串长度。


