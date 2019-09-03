package topics.Heap.l295FindMedianfromDataStream;
import java.util.*;

// using one min heap and one max heap to find the median in O(1) time
// logN add
public class MedianFinder {
    PriorityQueue<Integer> first;
    PriorityQueue<Integer> second;
    /** initialize your data structure here. */
    public MedianFinder() {
        first = new PriorityQueue<>(Collections.reverseOrder());
        second = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(first.size() == 0 || first.peek() > num) {
            first.offer(num);
        }
        else {
            second.offer(num);
        }
        while(second.size() > first.size()) first.offer(second.poll());
        while(first.size() > second.size() + 1) second.offer(first.poll());
    }

    public double findMedian() {
        if((first.size() + second.size()) % 2 == 1) return first.peek();
        else {
            return (first.peek() + second.peek()) / 2.0;
        }
    }
}

// follow up, what if the input is between 1 ~ 100
// use a bucket to record every number's appear time
// add O(1) find O(1)
// if only 1% number is bigger than 100, you can use an extra array as the bucket for number that is bigger than 100
class MedianFinder2 {
    int A[] = new int[100], n = 0;

    public void addNum(int num) {
        A[num]++;
        n++;
    }

    public double findMedian() {
        int count = 0, i = 0;
        while (count < n/2) count += A[i++];
        int j = i;
        while (count < n/2+1) count += A[j++];
        return (n%2 == 1) ? j-1 : (i+j-2) / 2.0;
    }
}