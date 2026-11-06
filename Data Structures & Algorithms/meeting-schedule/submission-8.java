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
        for (int index = 1; index < intervals.size(); index++) {
            Interval first = intervals.get(index - 1);
            Interval second = intervals.get(index);
            if (first.end > second.start) {
                return false;
            }
        }
        return true;
    }
}
