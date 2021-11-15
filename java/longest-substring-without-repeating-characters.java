package java;

import java.util.HashMap;
import java.util.Map;

class LongestSubstringWithoutDuplicate {
    /**
     * 查询处最长子串的长度
     * @param s 提供的字符串
     * @return 不重复的最长子串长度（注意：不是子序列）
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 0) return 0;
        // 滑动窗口的最左端
        int left = 0;
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        // 遍历，使i作为滑动窗口的右端，每次将一个字母包括进来，check是否有重复字母；
        // 如果有重复字母，则将left更新为上一次这个字母出现的位置+1。并更新这个字母的最新位置。
        // 然后继续计算最大值，每次取大值
        for (int i = 0; i < len; i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
