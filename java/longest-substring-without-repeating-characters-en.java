package java;

import java.util.Map;
import java.util.HashMap;

class LongestSubstringWithoutRepeatingCharactersEn {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length(), ans = 0;
        if (len == 0) return ans;
        int left = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // if duplicate char index is less that left, than use left
                // otherwise use map.get(c) + 1
                left = Math.max(left, map.get(c) + 1);
            }
            ans = Math.max(ans, i - left + 1);
            map.put(c, i);
        }
        return ans;
    }
}
