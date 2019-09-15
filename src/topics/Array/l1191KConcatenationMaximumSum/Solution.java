package topics.Array.l1191KConcatenationMaximumSum;

public class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int[] prefix = new int[arr.length];
        int[] suffix = new int[arr.length];
        int mod = 1000000007;
        prefix[0] = arr[0];
        suffix[arr.length - 1] = arr[arr.length - 1];
        int preMax = 0;
        preMax = Math.max(prefix[0], preMax);
        for(int i = 1; i < arr.length; ++i) {
            prefix[i] = prefix[i - 1] + arr[i] ;
            preMax = Math.max(preMax, prefix[i]);
        }
        int singleMax = compute(arr);
        int sufMax = 0;
        sufMax = Math.max(suffix[arr.length - 1], sufMax);
        for(int i = arr.length - 2; i >= 0; --i) {
            suffix[i] = suffix[i + 1] + arr[i];
            sufMax = Math.max(suffix[i], sufMax);
        }

        int sum = suffix[0];

        if(k == 0) return 0;
        else if(k == 1) return Math.max(preMax, Math.max(singleMax, sufMax));
        else {
            boolean flag = false;
            int res = (sufMax % mod + preMax % mod) % mod;
            if(res > singleMax) flag = true;

            if(sum > 0) {
                for(int i = 0; i < k - 2; ++i) {
                    res = (res % mod + sum);
                    if(res > singleMax) flag = true;
                }
            }
            return flag ?  res % mod : singleMax;
        }
    }

    private int compute(int[] arr) {
        int max = 0;
        int start = 0, end = 0;
        int cur = 0;
        while(end < arr.length) {
            cur += arr[end++];
            max = Math.max(cur, max);
            if(cur < 0) {
                while(cur < 0) {
                    cur -= arr[start++];
                }
            }
            max = Math.max(cur, max);
        }
        return max;
    }
}