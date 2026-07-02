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
        for (int number = 1; number <= n; number++) {
            if (guess(number) == 0) {
                return number;
            }
        }
        return n;
    }
}