package java;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class CourseSchedule {
    /**
     * 使用一个入度表，和邻接数组
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            numCourses -= 1;
            for (int cur : ajacency.get(pre)) {
                indegrees[cur]--;
                if (indegrees[cur] == 0) queue.offer(cur);
            }
        }
        return numCourses == 0;
    }
}
