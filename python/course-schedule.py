from collections import deque
from typing import List

def canFinish(numCourses: int, prerequisites: List[List[int]]) -> bool:
    '''
    1. 入度表
    2. 有向无环图
    这里我用入度表来解
    '''
    indegrees = [0 for _ in range(numCourses)]
    ajacency = [[] for _ in range(numCourses)]
    for course, pre in prerequisites:
        indegrees[course] += 1
        ajacency[pre].append(course)
    queue = deque()
    # 将没有前置课程的课入队
    for i in range(numCourses):
        if not indegrees[i]: queue.append(i)
    while queue:
        pre = queue.popleft()
        numCourses -= 1
        for cur in ajacency[pre]:
            indegrees[cur] -= 1
            if not indegrees[cur]: queue.append(cur)
    return not numCourses
