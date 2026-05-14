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
    public int minMeetingRooms(List<Interval> intervals) {
        int size = intervals.size();
        int[] start = new int[size];
        int[] end = new int[size];

        for (int index = 0; index < size; index++) {
            start[index] = intervals.get(index).start;
            end[index] = intervals.get(index).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int result = 0;
        int count = 0;
        int s = 0;
        int e = 0;
        while (s < size) {
            if (start[s] < end[e]) {
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
