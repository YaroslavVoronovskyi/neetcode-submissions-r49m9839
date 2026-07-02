/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1;
        int right = n;
        while (true) {
            int middle1 = left + (right - left) / 3;
            int middle2 = right - (right - left) / 3;
            if (guess(middle1) == 0) {
                return middle1;
            }
            if (guess(middle2) == 0) {
                return middle2;
            }
            if (guess(middle1) + guess(middle2) == 0) {
                left = middle1 + 1;
                right = middle2 - 1;
            } else if (guess(middle1) == -1) {
                right = middle1 - 1;
            } else {
                left = middle2 + 1;
            }
        }
    }
}