package topics.Design.l1172DinnerPlateStacks;
import java.util.*;
public class DinnerPlates {
    TreeMap<Integer, Stack<Integer>> map;
    int cap;
    Integer leftmost;
    Integer rightmost;
    public DinnerPlates(int capacity) {
        cap = capacity;
        map = new TreeMap<>();
        leftmost = 0;
        rightmost = 0;
    }

    public void push(int val) {
        if(!map.containsKey(leftmost)) {
            map.put(leftmost, new Stack<>());
        }
        map.get(leftmost).push(val);
        while(map.get(leftmost).size() == cap) {
            Integer next = map.higherKey(leftmost);
            if(next == null) {
                leftmost++;
                rightmost = leftmost;
                map.put(leftmost, new Stack<>());
            }
            else leftmost = next;
        }
    }

    public int pop() {
        if(!map.containsKey(rightmost) || map.get(rightmost).empty()) {
            map.remove(rightmost);
            Integer next = map.lowerKey(rightmost);
            if(next == null) return -1;
            if(leftmost.compareTo(rightmost) == 0) {
                leftmost = next;
            }
            rightmost = next;
            return pop();
        }
        else return map.get(rightmost).pop();
    }

    public int popAtStack(int index) {
        if(!map.containsKey(index)) return -1;
        else {
            if(index == rightmost) return pop();
            if(map.get(index).empty()) return -1;
            int res = map.get(index).pop();
            if(index < leftmost) leftmost = index;
            return res;
        }
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
