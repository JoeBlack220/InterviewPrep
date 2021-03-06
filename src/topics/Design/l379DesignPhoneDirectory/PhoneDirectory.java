package topics.Design.l379DesignPhoneDirectory;

public class PhoneDirectory {
    // using a boolean array
    // get O(n) check O(1) release O(1)
    // space O(n)
    boolean[] numbers;
    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        numbers = new boolean[maxNumbers];
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        for(int i = 0; i < numbers.length; i++) {
            if(!numbers[i]) {
                numbers[i] = true;
                return i;
            }
        }
        return -1;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        return !numbers[number];
    }

    /** Recycle or release a number. */
    public void release(int number) {
        numbers[number] = false;
    }
}
