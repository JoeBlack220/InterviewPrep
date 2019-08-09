package topics.Design.l346MovingAveragefromDataStream;
import java.util.*;
public class MovingAverage {
    Deque<Integer> deque;
    int size;
    int sum;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        deque = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if(deque.size() == size) {
            sum -= deque.pollFirst();
            sum += val;
            deque.offerLast(val);
            return (double) sum / deque.size();
        }
        else {
            sum += val;
            deque.offerLast(val);
            return (double) sum / deque.size();
        }
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
