package leetcode.Array.l1109CorporateFlighBookings;

public class Solution {
    // Since ranges are continuous, what if we add reservations to the first flight in the range, and remove them after the last flight in range? We can then use the running sum to update reservations for all flights.
    // similar to ... sorry I forgot
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for(int[] booking: bookings) {
            res[booking[0] - 1] += booking[2];
            if(booking[1] < n) res[booking[1]] -= booking[2];
        }
        int sum = 0;
        for(int i = 0; i < n; i ++) {
            sum += res[i];
            res[i] = sum;
        }
        return res;
    }
}
