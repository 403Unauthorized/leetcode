// 786. 第 K 个最小的素数分数 - Hard
// https://leetcode-cn.com/problems/k-th-smallest-prime-fraction/
package java;

import java.util.PriorityQueue;

class KthSmallestPrimeFraction {
    /**
     * 使用了优先级队列 PriorityQueue 的排序的特性
     * 维护每个除 1 以外以每个元素为分母，以头几个元素为分子的分数索引组合。
     */
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int len = arr.length;
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            double i1 = arr[a[0]] * (1.0 / arr[a[1]]), i2 = arr[b[0]] * (1.0 / arr[b[1]]);
            return Double.compare(i1, i2);
        });
        for (int i = 1; i < len; i++) q.add(new int[]{0, i});
        while (k-- > 1) {
            int[] p = q.poll();
            int i = p[0], j = p[1];
            if (i + 1 < j) q.add(new int[]{i + 1, j});
        }
        int[] p = q.poll();
        return new int[]{arr[p[0]], arr[p[1]]};
    }
}
