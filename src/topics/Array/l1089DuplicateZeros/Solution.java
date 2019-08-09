package topics.Array.l1089DuplicateZeros;

public class Solution {
    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        int[] temp = new int[len];
        for(int i = 0; i < len; ++i) {
            temp[i] = arr[i];
        }
        int curIndex = 0;
        boolean flag = false;
        for(int i = 0; i < len; ++i) {
            if(temp[curIndex] == 0 && !flag) {
                arr[i] = 0;
                curIndex++;
                flag = true;
            }
            else if(flag) {
                flag = false;
                arr[i] = 0;
            }
            else {
                arr[i] = temp[curIndex];
                curIndex++;
            }
        }

    }
}
