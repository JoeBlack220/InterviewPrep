package topics.String.l481MagicalString;

public class Solution {

//    the magical sequence is actually called Kolakoski sequence https://en.wikipedia.org/wiki/Kolakoski_sequence
    // we can just simulate the constructing process of the sequence and get the result
    public int magicalString(int n) {
        if(n <= 0) return 0;
        if(n <= 3) return 1;

        int[] arr = new int[n];
        arr[0] = 1; arr[1] = 2; arr[2] = 2;
        int tail = 3, num = 1, head = 2;
        int res = 1;
        while(tail < n) {
            for(int i = 0; i < arr[head] && tail < n; ++i) {
                arr[tail++] = num;
                if(num == 1) res++;
            }
            head++;
            num ^= 3;
        }
        return res;
    }
}