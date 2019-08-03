package leetcode.Design.l281ZigzagIterator;
import java.util.*;
public class ZigzagIterator {
    ListIterator<Integer> l1;
    ListIterator<Integer> l2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        l1 = v1.listIterator();
        l2 = v2.listIterator();
    }

    public int next() {
        if(hasNext()) {
            if(!l1.hasNext()) return l2.next();
            else {
                ListIterator<Integer> temp = l1;
                l1 = l2;
                l2 = temp;
                return l2.next();
            }
        }
        return 0;
    }

    public boolean hasNext() {
        return l1.hasNext() || l2.hasNext();
    }
}
// queue solution
class ZigzagIterator2 {
    Queue<Iterator<Integer>> queue;
    public ZigzagIterator2(List<Integer> v1, List<Integer> v2) {
        this.queue = new LinkedList<Iterator<Integer>> ();
        if(v1.iterator().hasNext())
            queue.offer(v1.iterator());
        if(v2.iterator().hasNext())
            queue.offer(v2.iterator());
    }

    public int next() {
        Iterator<Integer> next = queue.poll();
        int a  = next.next();
        if(next.hasNext()) queue.offer(next);
        return a;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}