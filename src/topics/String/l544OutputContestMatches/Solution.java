package topics.String.l544OutputContestMatches;
import java.util.*;
public class Solution {
    public String findContestMatch(int n) {
        Deque<String> queue1 = new LinkedList<>();
        Deque<String> queue2 = new LinkedList<>();
        for(int i = 1; i <= n; ++i) {
            queue1.add(Integer.toString(i));
        }

        while(queue1.size() != 1) {
            Deque<String> temp = queue1;
            queue1 = queue2;
            queue2 = temp;

            while(!queue2.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                sb.append('(');
                sb.append(queue2.pollFirst());
                sb.append(',');
                sb.append(queue2.pollLast());
                sb.append(')');
                queue1.offer(sb.toString());
            }
        }

        return queue1.poll();

    }
}