package point_to_offer;

import java.util.HashMap;
import java.util.Map;

class OfferII010 {
    /**
     * 前缀和 + HashTable记录前缀和
     * 检查 HashTable 中有没有 sum - k 这样的前缀和
     * 如果有，就ans += map.get(sum - k);
     * 如果没有，ans += 0
     * 然后将这个前缀和加入到 HashTable里面
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
