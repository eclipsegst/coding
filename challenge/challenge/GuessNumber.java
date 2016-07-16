package challenge;

/**
 * @author Zhaolong Zhong Jul 16, 2016
 * 
 * Guess Number Higher or Lower
 * 
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 * -1 : My number is lower
 *  1 : My number is higher
 *  0 : Congrats! You got it!
 * 
 * Example:
 * n = 10, I pick 6.
 * Return 6.
 */

/* The guess API is defined in the parent class GuessGame.
@param num, your guess
@return -1 if my number is lower, 1 if my number is higher, otherwise return 0
   int guess(int num); */

public class GuessNumber extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
        	int mid = left + ((right - left) >> 1);
        	int res = guess(mid);
        	if (res == 0) return mid;
        	else if (res == 1) left = mid + 1;
        	else right = mid - 1;
        }
        return left;
    }
}

class GuessGame {
	public int guess(int num){
		return 0;
	}
}


