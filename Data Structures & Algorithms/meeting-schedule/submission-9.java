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
        Collections.sort(intervals, Comparator.comparingInt(a -> a.start));
        for (int index = 0; index < intervals.size() - 1; index++) {
            if (intervals.get(index + 1).start < intervals.get(index).end) {
                return false;
            }
        }
        return true;
    }
}
