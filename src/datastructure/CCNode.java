package datastructure;

public class CCNode {
    CCNode next;
    int data;

    public CCNode(int d) {
       data = d;
    }

    void appendToTail(int d) {
        CCNode end = new CCNode(d);
        CCNode n = this;
        while(n.next != null) {
            n = n.next;
        }
        n.next = end;
    }
}
