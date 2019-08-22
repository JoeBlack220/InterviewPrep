package topics.Sort.l912SortanArray;
import java.util.*;
public class Solution {
    // solution 1, using the library
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}

class Solution2 {
    // solution 2, merge sort

    int[] aux;
    public int[] sortArray(int[] nums) {
        int len = nums.length;
        aux = new int[len];
        sort(nums, 0, len - 1);
        return nums;
    }

    private void sort(int[] nums, int start, int end) {
        if(start >= end) return;
        int mid = start + (end - start) / 2;
        sort(nums, start, mid);
        sort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end) {
        for(int i = start; i <= end; ++i) aux[i] = nums[i];
        int i = start, j = mid + 1;
        int curIndex = start;
        while(curIndex <= end) {
            if(j > end) nums[curIndex++] = aux[i++];
            else if(i > mid) nums[curIndex++] = aux[j++];
            else if(aux[i] <= aux[j]) nums[curIndex++] = aux[i++];
            else nums[curIndex++] = aux[j++];
        }
    }
}

// solution 3, quick sort
class Solution3 {
    public int[] sortArray(int[] nums) {
        shuffle(nums);
        int len = nums.length;
        quicksort(nums, 0, len - 1);
        return nums;
    }

    private void quicksort(int[] nums, int start, int end) {
        if(start >= end) return;
        int k = partition(nums, start, end);
        quicksort(nums, start, k - 1);
        quicksort(nums, k + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int curIndex = start;
        for(int i = start; i < end; ++i) {
            if(nums[i] <= pivot) {
                exch(nums, i, curIndex++);
            }
        }
        exch(nums, curIndex, end);
        return curIndex;
    }

    private void shuffle(int[] nums) {
        Random random = new Random();
        for(int i = 1; i < nums.length; ++i) {
            exch(nums, i, random.nextInt(i + 1));
        }
    }

    private void exch(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}