package topics.Math.l519RandomFlipMatrix;
import java.util.*;
// every time we randomly pick a number from 1 to total and set it to 1;
// then swap the element to the tail, so we have total - 1 slots to be swap
// record that mapping use a hash map
public class Solution {

    Map<Integer, Integer> map;
    int rows, cols, total;
    Random rand;

    public Solution(int n_rows, int n_cols) {
        map = new HashMap<>();
        rand = new Random();
        rows = n_rows;
        cols = n_cols;
        total = rows * cols;
    }

    public int[] flip() {
        int r = rand.nextInt(total--);
        int x = map.getOrDefault(r, r);
        map.put(r, map.getOrDefault(total, total));
        return new int[]{x / cols, x % cols};
    }

    public void reset() {
        map = new HashMap<>();
        total = rows * cols;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */