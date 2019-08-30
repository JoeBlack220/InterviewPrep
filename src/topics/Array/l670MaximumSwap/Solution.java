package topics.Array.l670MaximumSwap;

public class Solution {
    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        int[] dict = new int[10];
        for(int i = 0; i < arr.length; ++i) {
            dict[arr[i] - '0'] = i;
        }

        for(int i = 0; i < arr.length; ++i) {
            int cur = arr[i] - '0';
            for(int j = 9; j > cur; --j) {
                if(i < dict[j]) {
                    arr[i] = (char)(j + '0');
                    arr[dict[j]] = (char)(cur + '0');
                    return Integer.parseInt(new String(arr));
                }
            }
        }

        return num;
    }

}
