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
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        int size = intervals.size();
        for (int index = 1; index < size; index++) {
            if (intervals.get(index).start < intervals.get(index - 1).end) {
                return false;
            }
        }
        return true;
    }
}
