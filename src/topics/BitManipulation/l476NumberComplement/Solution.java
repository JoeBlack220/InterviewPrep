package topics.BitManipulation.l476NumberComplement;

public class Solution {
    // create a bit mask that have the same number of digit with the original number, but all 1s
    // for example, if num is 5(101) then the mask is 111
    // then flip the whole number and AND with the bit mask
    // we can get what we want
    public int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}
