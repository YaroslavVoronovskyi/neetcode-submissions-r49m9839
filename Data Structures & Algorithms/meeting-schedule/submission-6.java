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
        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        for (int index = 1; index < intervals.size(); index++) {
            Interval firstInterval = intervals.get(index - 1);
            Interval secondInterval = intervals.get(index);
            if (firstInterval.end > secondInterval.start) {
                return false;
            }
        }
        return true;
    }
}
