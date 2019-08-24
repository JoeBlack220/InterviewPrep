package topics.Minmax.l843GuesstheWord;
import java.util.*;
public class Solution {
    // we first randomly pick a string to guess
    // then we would get how many (suppose the number is x) characters we matched with the secret
    // so the words in the original wordlist that have x characters match with the chosen string is
    // a candidate for the right answer, we add them to a list for the next guess
    public void findSecretWord(String[] wordlist, Master master) {
        for (int i = 0, x = 0; i < 10 && x < 6; ++i) {
            String guess = wordlist[new Random().nextInt(wordlist.length)];
            x = master.guess(guess);
            List<String> wordlist2 = new ArrayList<>();
            for (String w : wordlist)
                if (match(guess, w) == x)
                    wordlist2.add(w);
            wordlist = wordlist2.toArray(new String[wordlist2.size()]);
        }
    }
    public int match(String a, String b) {
        int matches = 0;
        for (int i = 0; i < a.length(); ++i) if (a.charAt(i) == b.charAt(i)) matches ++;
        return matches;
    }
    // bogus master class
    // to eliminate the warnings
    class Master{
        public int guess(String s) {
            return s.length();
        }
    }
}
