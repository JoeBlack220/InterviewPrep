package topics.Design.l622DesignCircularQueue;

public class MyCircularQueue {
    int[] arr;
    int len;
    int front;
    int end;
    int cur_len;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        arr = new int[k];
        len = k;
        front = -1;
        end = -1;
        cur_len = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()) return false;

        end = (end + 1) % len;
        arr[end] = value;
        cur_len++;
        if(cur_len == 1) front = end;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) return false;
        cur_len--;
        front = (front + 1) % len;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) return -1;
        return arr[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) return -1;

        return arr[end];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return cur_len == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return cur_len == len;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */