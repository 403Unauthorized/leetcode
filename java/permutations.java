package java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        backtrack(nums, visited, new LinkedList<>());
        return ans;
    }

    public void backtrack(int[] nums, boolean[] visited, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int n : nums) {
            if (list.contains(n)) {
                continue;
            }
            list.add(n);
            backtrack(nums, visited, list);
            list.removeLast();
        }

    }
}