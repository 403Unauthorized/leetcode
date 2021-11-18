// 983. 最低票价
// https://leetcode-cn.com/problems/minimum-cost-for-tickets/
package java;

import java.util.HashSet;
import java.util.Set;

class MinimumCostForTickets {
    int[] s = {1, 7, 30};
    public int minCostTickets(int[] days, int[] costs) {
        int lastDay = days[-1];
        int firstDay = days[0];
        int[] dp = new int[lastDay + 31];
        Set<Integer> set = new HashSet<>();
        for (int d : days) {
            set.add(d);
        }
        for (int i = lastDay; i >= firstDay; i--) {
            if (set.contains(i)) {
                int minCost = Integer.MAX_VALUE;
                for (int j = 0; j < costs.length; j++) {
                    minCost = Math.min(minCost, dp[i + s[j]] + costs[j]);
                }
                dp[i] = minCost;
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[firstDay];
    }
}
