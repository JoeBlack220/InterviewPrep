package topics.TopologicalSort.l207CourseSchedule;
import java.util.*;

public class Solution {
    // add all nodes with 0 in-degrees into the queue
    // remove those nodes
    // then add all the nodes with 0 in-degrees after the first remove
    // do it repeatedly until all the nodes have been removed
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        Set<Integer>[] sets = new Set[numCourses];

        for(int i = 0; i < numCourses; ++i) sets[i] = new HashSet<>();
        for(int[] pre: prerequisites) {
            sets[pre[0]].add(pre[1]);
            indegrees[pre[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; ++i) {
            if(indegrees[i] == 0) queue.offer(i);
        }

        int coursesLeft = numCourses - queue.size();
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int next: sets[cur]) {
                indegrees[next]--;
                if(indegrees[next] == 0) {
                    coursesLeft--;
                    queue.offer(next);
                }
            }
        }
        return coursesLeft == 0;
    }
}
