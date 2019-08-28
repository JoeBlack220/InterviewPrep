package topics.DepthFirstSearch.l277FindtheCelebrity;

public class Solution extends Relation {
    // two pass O(n)
    public int findCelebrity(int n) {
        int candidate = 0;
        // find the candidate
        for(int i = 0; i < n; i++) {
            if(knows(candidate, i)) candidate = i;
        }
        // validate the candidate
        for(int i = 0; i < n; ++i) {
            if(!knows(i, candidate)) return -1;
            if(i != candidate && knows(candidate, i)) return -1;
        }
        return candidate;
    }
}

// bogus relation class
class Relation {
    public boolean knows(int i, int j) {
        return true;
    }
}
