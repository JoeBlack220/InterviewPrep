package topics.Array.l904FruitIntoBaskets;

public class Solution {
    public int totalFruit(int[] tree) {
        int slow = 0, fast = 0, count1 = 0, count2 = 0, fruit1 = tree[0], fruit2 = tree[0];
        int res = 0;
        while(fast < tree.length) {
            if(fruit1 == tree[fast]) count1++;
            else if(fruit2 == tree[fast]) count2++;
            else {
                while(count1 != 0 && count2 != 0 && slow < fast) {
                    if(tree[slow] == fruit1) {
                        count1 --;
                    }
                    else if(tree[slow] == fruit2) {
                        count2 --;
                    }
                    slow++;
                }
                if(count1 == 0) {
                    fruit1 = tree[fast];
                    count1++;
                }
                else if(count2 == 0) {
                    fruit2 = tree[fast];
                    count2++;
                }
            }
            fast++;
            res = Math.max(res, fast - slow);
        }
        return res;
    }
}
