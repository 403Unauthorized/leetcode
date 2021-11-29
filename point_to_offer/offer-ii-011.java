package point_to_offer;

import java.util.HashMap;
import java.util.Map;

class OfferII011 {
    /**
     * 思路：使用前缀和与HashTable的思想
     * 因为数组中只可能有0和1，所以可以把0看作-1，然后找出和为0的最长子数组
     * 这道题就变成了《和为k的最长子数组》
     */
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                sum += 1;
            } else {
                sum -= 1;
            }
            if (map.containsKey(sum)) {
                int prev = map.get(sum);
                ans = Math.max(ans, i - prev);
            } else {
                map.put(sum, i);
            }
        }
        return ans;
    }
}
