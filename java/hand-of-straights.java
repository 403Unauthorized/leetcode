package java;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HandOfStraights {
    /**
     * 先用一个Map来记录每个元素出现的次数
     * 因为是要找顺子，应该从点数最小的开始，所以需要用优先级队列排序
     * 将最小的元素一个一个取出来尝试能否组成顺子，
     * 只要其中一个无法组成顺子则返回false
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        for (int n : hand) {
            q.add(n);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        while (!q.isEmpty()) {
            int num = q.poll();
            if (map.get(num) == 0) continue;
            for (int i = 0; i < groupSize; i++) {
                int c = map.getOrDefault(num + i, 0);
                if (c == 0) return false;
                map.put(num + i, c - 1);
            }
        }
        return true;
    }
}