package topics.TopologicalSort.l210CourseScheduleII;
import java.util.*;
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Set<Integer>[] sets = new Set[numCourses];
        int[] res = new int[numCourses];
        int curIndex = 0;
        for(int i = 0; i < numCourses; ++i) sets[i] = new HashSet<>();
        for(int[] pre: prerequisites) {
            indegrees[pre[0]]++;
            sets[pre[1]].add(pre[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; ++i) {
            if(indegrees[i] == 0) {
                queue.add(i);
                res[curIndex++] = i;
            }
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next: sets[cur]) {
                indegrees[next]--;
                if(indegrees[next] == 0) {
                    queue.offer(next);
                    res[curIndex++] = next;
                }
            }
        }
        return curIndex == numCourses ? res : new int[]{};
    }
}
