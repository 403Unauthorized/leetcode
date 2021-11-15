package java;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

    Map<String, Integer> map;
    
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int ans = 0;
        for (String key : map.keySet()) {
            if (key.startsWith(prefix)) {
                ans += map.get(key);
            }
        }
        return ans;
    }
}
