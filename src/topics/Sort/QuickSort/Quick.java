package topics.Sort.QuickSort;
import java.util.*;
// example code from Algorithms 4th edition
public class Quick {
    public static void sort(Comparable[] a) {
//        shuffle(a);                        // eliminate dependence on input
        sort(a, 0, a.length - 1);
    }
    private static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;            // left and right scan indices
        Comparable v = a[lo];              // partitioning item
        while(true) {
            while(less(a[++i], v)) if (j == hi) break;
            while(less(v, a[--j])) if (j == lo) break;
            // indexes that are less than i have values smaller than v
            // indexes that are more than j have values bigger than v
            // after one iteration, the k will exchange with j
            // than k is in the place that it belong to in the final result
            // we recursively do the same operations on the subarray on the left of k
            // and on the right of k
            if(i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    private static boolean less(Comparable a, Comparable b) {
        if(a.compareTo(b) < 0) return true;
        return false;
    }
    private void shuffle(Comparable[] a) {

        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(a, ind, r);
        }
    }

    // 3-way partitioning
    public class Quick3way
    {
        private void sort(Comparable[] a, int lo, int hi)
        {  // See page 289 for public sort() that calls this method.
            if (hi <= lo) return;
            int lt = lo, i = lo+1, gt = hi;
            Comparable v = a[lo];
            while (i <= gt)
            {
                int cmp = a[i].compareTo(v);
                if      (cmp < 0) exch(a, lt++, i++);
                else if (cmp > 0) exch(a, i, gt--);
                else              i++;
            }  // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
            sort(a, lo, lt - 1);
            sort(a, gt + 1, hi);
        } }
}
