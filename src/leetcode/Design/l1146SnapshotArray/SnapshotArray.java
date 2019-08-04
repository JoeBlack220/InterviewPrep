package leetcode.Design.l1146SnapshotArray;
import java.util.TreeMap;
public class SnapshotArray {

    // get O(logN) snap O(1) setO(1)
    TreeMap<Integer, Integer>[] map;
    int version;
    public SnapshotArray(int length) {
        map = new TreeMap[length];
        for(int i = 0; i < length; ++i) {
            map[i] = new TreeMap<>();
            map[i].put(version, 0);
        }
        version = 0;
    }

    public void set(int index, int val) {
        map[index].put(version, val);
        // System.out.println(map[index].floorEntry(version).getValue());
    }

    public int snap() {
        return version++;
    }

    public int get(int index, int snap_id) {
        return map[index].floorEntry(snap_id).getValue();
    }
}
