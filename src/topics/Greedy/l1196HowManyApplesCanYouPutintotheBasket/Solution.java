package topics.Greedy.l1196HowManyApplesCanYouPutintotheBasket;
import java.util.Arrays;
public class Solution {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int res = 5000;
        int num = 0, index = 0;
        while(index < arr.length && res >= 0) {
            res -= arr[index++];
            num++;
        }
        return res < 0 ? num - 1 : num;
    }
}