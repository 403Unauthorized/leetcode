package java;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// 思路和课程表一样，每次pop元素时把这个元素加到ans里就行
class CourseSchedule2 {
    List<Integer> ans = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> ajacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            ajacency.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            indegrees[prerequisites[i][0]]++;
            ajacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.offer(i);
        }
        while (!queue.isEmpty()) {
            int pre = queue.pollFirst();
            ans.add(pre);
            numCourses -= 1;
            for (int cur : ajacency.get(pre)) {
                indegrees[cur]--;
                if (indegrees[cur] == 0) queue.offer(cur);
            }
        }
        return numCourses == 0 ? ans.stream().mapToInt(i -> i).toArray() : new int[0];
    }
}
