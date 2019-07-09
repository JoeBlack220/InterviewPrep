package leetcode.String.l271EncodeAndDecodeStrings;
import java.util.*;
import java.util.stream.*;

// method1, use length at the start of a string
public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            i = slash + size + 1;
            ret.add(s.substring(slash + 1, i));
        }
        return ret;
    }
}

// method 2
class Codec2 {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder out = new StringBuilder();
        for (String s : strs)
            out.append(s.replace("#", "##")).append(" # ");
        return out.toString();
    }

    public List<String> decode(String s) {
        List strs = new ArrayList();
        String[] array = s.split(" # ", -1); // split's limit < 0 then we will retain the empty strings
        for (int i=0; i<array.length-1; ++i)
            strs.add(array[i].replace("##", "#"));
        return strs;
    }
}

// same idea as method 2, but using stream
class Codec3 {
    public String encode(List<String> strs) {
        return strs.stream()
                .map(s -> s.replace("#", "##") + " # ")
                .collect(Collectors.joining());
    }

    public List<String> decode(String s) {
        List strs = Stream.of(s.split(" # ", -1))
                .map(t -> t.replace("##", "#"))
                .collect(Collectors.toList());
        strs.remove(strs.size() - 1);
        return strs;
    }
}