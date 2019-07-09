package leetcode.String.l541ReverseStringII;

public class Solution {
    // beats 17%
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int len = s.length();
        while(start < len) {
            for(int i = 0; i < k && start + i < len; ++i) {
                sb.insert(start, s.charAt(start + i));
            }
            if(start + k >= len) break;
            else {
                sb.append(s.substring(start + k, Math.min(len, start + 2 * k)));
                start += 2 * k;
            }
        }
        return sb.toString();
    }
    // same space and time complexity
    // but char[] is faster than StringBuilder
    // beats 100%
    public String reverseStr1(String s, int k) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int i = 0;
        while(i < n) {
            int j = Math.min(i + k - 1, n - 1);
            swap(arr, i, j);
            i += 2 * k;
        }
        return String.valueOf(arr);
    }
    private void swap(char[] arr, int l, int r) {
        while (l < r) {
            char temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }
}