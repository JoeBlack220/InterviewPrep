package topics.Array.l384ShuffleanArray;
import java.util.Random;
public class Solution {
    int[] arr;
    Random random;

    public Solution(int[] nums) {
        arr = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return arr;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] temp = new int[arr.length];
        for(int i = 0; i < arr.length; ++i) temp[i] = arr[i];
        for(int ind = 1; ind < arr.length; ind++) {
            final int r = random.nextInt(ind + 1);
            exch(temp, ind, r);
        }
        return temp;
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}