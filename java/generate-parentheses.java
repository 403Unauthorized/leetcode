// 22. 括号生成 - Medium
// https://leetcode-cn.com/problems/generate-parentheses/
package java;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用回溯或者深度优先搜索可解决
 * 但是我们需要判断剩余可用的括号数
 * 如果剩余可用的右括号数小于左括号数，则该分支无效，直接弃用。
 * 当左括号数和右括号数都为0时，则将当前字符串加入到答案中。
 */
class GenerateParenthesis {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs("", n, n);
        return ans;
    }

    public void dfs(String str, int open, int close) {
        if (open == 0 && close == 0) {
            ans.add(str);
            return;
        }

        if (close < open) {
            return;
        }

        if (open > 0) {
            dfs(str + "(", open - 1, close);
        }

        if (close > 0) {
            dfs(str + ")", open, close - 1);
        }
    }
}
