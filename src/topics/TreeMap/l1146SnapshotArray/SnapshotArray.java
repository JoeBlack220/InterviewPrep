package topics.TreeMap.l1146SnapshotArray;
import java.util.TreeMap;
public class SnapshotArray {
    TreeMap<Integer, Integer>[] lookup;
    int version;
    public SnapshotArray(int length) {
        lookup = new TreeMap[length];
        version = 0;
        for(int i = 0; i < length; ++i) {
            lookup[i] = new TreeMap<>();
            lookup[i].put(version, 0);
        }
    }

    public void set(int index, int val) {
        lookup[index].put(version, val);
    }

    public int snap() {
        return version++;
    }

    public int get(int index, int snap_id) {
        return lookup[index].floorEntry(snap_id).getValue();
    }
}

