package topics.String.l1138AlphabetBoardPath;
import java.util.*;
public class Solution {
    public String alphabetBoardPath(String target) {
        Map<Character, Pair> map = new HashMap<>();
        for(int i = 0; i < 26; ++i) {
            int x = i / 5;
            int y = i % 5;
            map.put((char)(i + 'a'), new Pair(x, y));
        }
        StringBuilder res = new StringBuilder();
        int curX = 0, curY = 0;
        for(char c: target.toCharArray()) {
            Pair cor = map.get(c);
            int diffX = curX - cor.x;
            int diffY = curY - cor.y;
            if(diffX > 0) {
                for(int i = 0; i < diffX; ++i) {
                    res.append('U');
                }
            }
            if(diffY > 0) {
                for(int i = 0; i < diffY; ++i) {
                    res.append('L');
                }
            }
            if(diffX < 0) {
                for(int i = 0; i > diffX; --i) {
                    res.append('D');
                }
            }
            if(diffY < 0) {
                for(int i = 0; i > diffY; --i) {
                    res.append('R');
                }
            }
            curX = cor.x;
            curY = cor.y;
            res.append('!');
        }
        return res.toString();
    }

    class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
