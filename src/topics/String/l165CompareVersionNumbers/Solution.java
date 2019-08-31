package topics.String.l165CompareVersionNumbers;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        return compareHelper(v1, 0, v2, 0);
    }

    private int compareHelper(String[] v1, int index1, String[] v2, int index2) {
        if(index1 == v1.length && index2 == v2.length) return 0;
        else if(index1 == v1.length) {
            for(int i = index2; i < v2.length; ++i) {
                if(Integer.parseInt(v2[i]) != 0) return -1;
            }
            return 0;
        }
        else if(index2 == v2.length) {
            for(int i = index1; i < v1.length; ++i) {
                if(Integer.parseInt(v1[i]) != 0) return 1;
            }
            return 0;
        }
        else {
            int curVersion1 = Integer.parseInt(v1[index1]);
            int curVersion2 = Integer.parseInt(v2[index2]);
            if(curVersion1 > curVersion2) return 1;
            else if(curVersion1 < curVersion2) return -1;
            else return compareHelper(v1, index1 + 1, v2, index2 + 1);
        }
    }
}