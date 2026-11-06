/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int size = intervals.size();
        for (int outer = 0; outer < size; outer++) {
            Interval first = intervals.get(outer);
            for (int inner = outer + 1; inner < size; inner++) {
                Interval second = intervals.get(inner);
                if (Math.min(first.end, second.end) > Math.max(first.start, second.start)) {
                    return false;
                }
            }
        }
        return true;
    }
}
