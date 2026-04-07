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
        for (int i = 0; i < size; i++) {
            Interval firstInterval = intervals.get(i);
            for (int j = i + 1; j < size; j++) {
                Interval secondInterval = intervals.get(j);
                if (Math.min(firstInterval.end, secondInterval.end) >
                        Math.max(firstInterval.start, secondInterval.start)) {
                    return false;
                }
            }
        }
        return true;
    }
}
