package java;
// 397. 整数替换
// https://leetcode-cn.com/problems/integer-replacement/

import java.util.HashMap;
import java.util.Map;

class IntegerReplacement {
    // public int integerReplacement(int n) {
    //     return dfs(n, 0);
    // }

    // public int dfs(int n, int replace) {
    //     if (n == 1) {
    //         return replace;
    //     }
    //     if (n % 2 == 0) {
    //         return dfs(n / 2, replace + 1);
    //     } else {
    //         int plus = dfs(n + 1, replace + 1);
    //         int minus = dfs(n - 1, replace + 1);
    //         return Math.min(plus, minus);
    //     }
    // }

    /**
     * 以上注释掉的方法在leetcode上执行会StackOverflow，因为最大数为2147483647
     * 所以需要将得出的结果记录下来，减少递归次数
     */
    Map<Long, Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
        return dfs(n * 1L);
    }

    public int dfs(long n) {
        if (n == 1) {
            return 0;
        }
        if (map.containsKey(n)) return map.get(n);
        int ans = n % 2 == 0 ? dfs(n / 2) : Math.min(dfs(n + 1), dfs(n - 1));
        map.put(n, ++ans);
        return ans;
    }
}