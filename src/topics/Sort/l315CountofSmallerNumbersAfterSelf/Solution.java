package topics.Sort.l315CountofSmallerNumbersAfterSelf;
import java.util.*;
public class Solution {

    class Pair {
        int val;
        int num;
        int index;
        public Pair(int val, int num, int index) {
            this.num = num;
            this.val = val;
            this.index = index;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;
        Pair[] aux = new Pair[len];
        Pair[] toSort = new Pair[len];
        for(int i = 0; i < len; ++i) {
            toSort[i] = new Pair(nums[i], 0, i);
        }
        mergeSort(aux, toSort, 0, len - 1);
        int[] res = new int[len];
        for(Pair p: toSort) {
            res[p.index] = p.num;
        }
        List<Integer> list = new ArrayList<>();
        for(int num: res) list.add(num);
        return list;
    }

    private void mergeSort(Pair[] aux, Pair[] toSort, int start, int end) {
        if(start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(aux, toSort, start, mid);
        mergeSort(aux, toSort, mid + 1, end);
        merge(aux, toSort, start, mid, end);
    }

    private void merge(Pair[] aux, Pair[] toSort, int start, int mid, int end) {
        int index1 = start, index2 = mid + 1;
        for(int i = start; i <= end; ++i) aux[i] = toSort[i];
        int curIndex = start;
        while(index1 <= mid || index2 <= end) {
            if(index2 > end) {
                Pair toAdd = aux[index1++];
                toAdd.num += index2 - mid - 1;
                toSort[curIndex++] = toAdd;
            }
            else if(index1 > mid) {
                Pair toAdd = aux[index2++];
                toSort[curIndex++] = toAdd;
            }
            else if(aux[index2].val < aux[index1].val) {
                Pair toAdd = aux[index2++];
                toSort[curIndex++] = toAdd;
            }
            else {
                Pair toAdd = aux[index1++];
                toAdd.num += index2 - mid - 1;
                toSort[curIndex++] = toAdd;
            }
        }
    }
}