package topics.String.PatternSearching.RabinKarp;
// Rabin-Karp slides the pattern one by one like the naive methods
// but it matches the hash values of the pattern with the hash value of the current string
// first we need to compute hash value for the pattern, then the hash value for
// all the substrings of text of length m
// time O(m+n) worst case(n^2)
public class RabinKarp {

    public int search(String s, String p) {
        // d -> total number of characters in the character set
        int d = 256;
        // q -> a prime number
        int q = 101;
        int i, M = p.length(), N = s.length();
        int sh = 0, ph = 0;
        // h is the wight that the first character in the current substring of s has
        int h = 1;
        // compute h -> pow(d, M - 1) % q
        for(i = 0; i < M - 1; ++i) h = (d * h) % q;
        // compute the hash value of the pattern and the first window of s
        for(i = 0; i < M; ++i) {
            sh = (s.charAt(i) + sh * d) % q;
            ph = (p.charAt(i) + ph * d) % q;
        }

        for(i = 0; i < M - N + 1; ++i) {
            if (sh == ph) {
                if (bruteForce(s, i, p)) return i;
            }
            if(i < N - M)
                sh = (d * (sh - h * s.charAt(i)) % q + s.charAt(i + M) + q) % q;
        }
        return -1;
    }

    private boolean bruteForce(String s, int index, String p) {
        int i = index, j = 0;
        while(j < p.length()) {
            if(s.charAt(i) != p.charAt(j)) return false;
        }
        return true;
    }
}
