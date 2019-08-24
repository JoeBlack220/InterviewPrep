package topics.Design.l146LRUCache;
import java.util.*;
// linked hash map solution
public class LRUCache {
    int cap;
    LinkedHashMap<Integer, Integer> map;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        Integer res = map.get(key);
        if(res == null) return -1;
        else {
            map.remove(key);
            map.put(key, res);
            return res;
        }
    }

    public void put(int key, int value) {
        if(map.size() == cap && !map.containsKey(key)) {
            map.remove(map.keySet().iterator().next());
        } else if(map.containsKey(key)) {
            map.remove(key);
        }
        map.put(key, value);
    }
}

// rewrite the removeEldestEntry function if the linked hash map is a easier way to do that
class LRUCache2 {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache2(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void put(int key, int value) {
        map.put(key, value);
    }
}

// double linked list and hash table solution
class LRUCache3 {

    class DNode {
        DNode prev;
        DNode next;
        int val;
        int key;
        public DNode(int v, int k) {
            val = v;
            key = k;
        }
    }

    Map<Integer, DNode> map;
    int cap;
    DNode head, tail;

    private void popTail() {
        map.remove(tail.prev.key);
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }

    private void addNode(DNode toAdd) {
        // System.out.println(toAdd.val);
        toAdd.next = head.next;
        head.next.prev = toAdd;
        toAdd.prev = head;
        head.next = toAdd;
        map.put(toAdd.key, toAdd);
    }

    private void removeNode(DNode toRemove) {
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
    }

    public LRUCache3(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        head = new DNode(0, 0);
        tail = new DNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        DNode res = map.get(key);
        removeNode(res);
        addNode(res);
        return res.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            DNode res = map.get(key);
            removeNode(res);
            res.val = value;
            addNode(res);
        }
        else {
            DNode toAdd = new DNode(value, key);
            addNode(toAdd);
            if(map.size() > cap) popTail();
        }
    }
}
