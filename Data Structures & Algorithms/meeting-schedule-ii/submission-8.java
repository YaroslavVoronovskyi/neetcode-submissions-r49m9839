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
        int[] starts = new int[size];
        int[] ends = new int[size];
        
        for (int index = 0; index < size; index++) {
            starts[index] = intervals.get(index).start;
            ends[index] = intervals.get(index).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int result = 0;
        int count = 0;
        int start = 0;
        int end = 0;

        while (start < size) {
            if (starts[start] < ends[end]) {
                start++;
                count++;
            } else {
                end++;
                count--;
            }
            result = Math.max(result, count);
        }
        return result;    
    }
}
