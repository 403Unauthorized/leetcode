package java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class RelativeRanks {
    /**
     * 排序/模拟
     */
    public String[] findRelativeRanks(int[] score) {
        String[] ssp = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
        int len = score.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(score[i], i);
        }
        Arrays.sort(score);
        String[] ans = new String[len];
        for (int i = 0; i < len; i++) {
            int idx = len - 1 - i;
            ans[map.get(score[i])] = idx < 3 ? ssp[idx] : String.valueOf(idx + 1);
        }
        return ans;
    }
}
