package java;

import java.util.Arrays;

class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
             int lhs = 1;
             boolean valid = false;
             for (int j = i + 1; j < nums.length; j++) {
                 if (nums[j] == nums[i]) {
                     lhs++;
                 }
                 if (nums[j] - nums[i] == 1) {
                     lhs++;
                     valid = true;
                 }
             }
             if (!valid) {
                 lhs = 0;
             }
             ans = Math.max(ans, lhs);
        }
        return ans;
    }
}
