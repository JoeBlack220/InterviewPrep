package topics.Design.l155MinStack;
import java.util.*;
// using priority queue solution
// push o(logn) pop O(logn) top O(1) getMin O(1)
public class MinStack {
    Deque<Integer> stack;
    PriorityQueue<Integer> pq;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        pq = new PriorityQueue<>();
    }

    public void push(int x) {
        stack.push(x);
        pq.offer(x);
    }

    public void pop() {
        int toPop = stack.pop();
        pq.remove(toPop);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return pq.peek();
    }
}

// solution 2, whenever we encounter a new min value, we push the original min value
// to the stack to record the last min value
// all operations are O(1)
class MinStack1 {
    int min;
    Deque<Integer> stack;
    /** initialize your data structure here. */
    public MinStack1() {
        stack = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if(x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        int toPop = stack.pop();
        if(toPop == min) min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
