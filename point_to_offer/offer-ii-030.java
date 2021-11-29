package point_to_offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

    int size;
    List<Integer> arr;
    LinkedHashSet<Integer> set;
    Random random = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        size = 0;
        map = new HashMap<>();
        set = new LinkedHashSet<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return set.remove(val);
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        arr = new ArrayList<>(set);
        return arr.get(random.nextInt(arr.size()));
    }
}
