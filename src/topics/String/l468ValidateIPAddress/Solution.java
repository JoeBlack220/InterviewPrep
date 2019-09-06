package topics.String.l468ValidateIPAddress;

// nothing interesting
// just validate each type one by one
// when split for ipv4, the . character must be escaped
// add -1 as the second parameter to split to specify the minimum length of
// the string after the processing
// by default it's 1
public class Solution {
    public String validIPAddress(String IP) {
        if(IP.equals("")) return "Neither";
        if(isIP4(IP)) return "IPv4";
        if(isIP6(IP)) return "IPv6";
        return "Neither";
    }

    public boolean isIP4(String IP){
        if(IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') return false;
        String[] temp = IP.split("\\.");
        if(temp.length != 4)return false;
        for(int i = 0; i < 4; i++){
            try{
                if(temp[i].startsWith("0") && temp[i].length() > 1) return false;
                if(Integer.parseInt(temp[i])>255 || temp[i].charAt(0)=='-' || temp[i].charAt(0)=='+')return false;
            }
            catch(NumberFormatException e){
                System.out.println("ERROR");
                return false;
            }
        }
        return true;
    }

    public boolean isIP6(String IP){
        if(IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') return false;
        String[] temp = IP.split(":");
        if(temp.length != 8)return false;
        for(int i = 0; i < 8; i++){
            if(temp[i].length() > 4 || temp[i].length() == 0) return false;
            for(int j = 0 ; j < temp[i].length(); j++){
                if((temp[i].charAt(j) >= '0' && temp[i].charAt(j) <= '9') || (temp[i].charAt(j) >= 'a' && temp[i].charAt(j) <= 'f') || (temp[i].charAt(j) >= 'A' && temp[i].charAt(j) <= 'F')){}
                else return false;
            }
        }
        return true;
    }
}

class Solution2 {
    public String validIPAddress(String IP) {
        if(IPV4(IP)) return "IPv4";
        else if(IPV6(IP)) return "IPv6";
        else return "Neither";
    }

    private boolean IPV4(String IP) {
        String[] arr = IP.split("\\.", -1);
        if(arr.length != 4) return false;
        try {
            for(String cur: arr) {
                if(cur.length() == 0 || (cur.length() != 1 && cur.charAt(0) == '0') || !Character.isDigit(cur.charAt(0))) return false;
                int num = Integer.parseInt(cur);
                if(num < 0 || num > 255) return false;
            }
            return true;
        } catch(Exception e){
            return false;
        }
    }

    private boolean IPV6(String IP) {
        String[] arr = IP.split(":", -1);
        if(arr.length != 8) return false;
        for(String cur: arr) {
            if(cur.length() > 4 || cur.length() <= 0) return false;
            for(char c: cur.toCharArray()) {
                if(!validIPChar(c)) return false;
            }
        }
        return true;
    }

    private boolean validIPChar(char c) {
        if(Character.isDigit(c)) return true;
        if(('a' <= c && c <= 'f') || (c <= 'F' && c >= 'A')) return true;
        return false;
    }
}