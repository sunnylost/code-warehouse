/*
A popular guessing game is "Guess the number", where one person selects a number in a known range, 
and another person tries to guess that number. After each guess, the first person reveals whether the guess was correct,
too high or too low.

Pretty soon one learns the best strategy, which is to guess the middle number among those not yet ruled out.
If there is no single middle number, then there are two numbers to choose from. 
In that case, we choose the smallest of those numbers.

The algorithm can be described like this:

Init lower and upper bound
Repeat
  x = (lower bound + upper bound)/2  (round down if necessary)
  Make guess x
  If x is too low, set lower bound to x+1
  If x is too high, set upper bound to x-1
Until x is correct
For instance, assume that the lower and upper bound initally are 1 and 9, respectively. 
The middle number in this range is 5. If this is "too low", the new bounds become 6 and 9. 
This range contains four numbers, and there is thus no single middle number. 
The two numbers in the middle are 7 and 8, and the smallest of these is 7, so our next guess then becomes 7.

Create a class GuessTheNumber which contains the method noGuesses which takes an int upper,
the initial upper bound of the range (the inital lower bound is always 1), and an int answer, 
the number selected by the first person. 
The method should return an int representing the total number of guesses required for the second person 
to guess the correct number using the method described above.
*/
public class GuessTheNumber {
	int noGuesses(int upper, int answer) throws Exception {
		int times = 0,
			lower = 1,
			guess = 0;
		if(upper < 1 || upper > 1000) {
			throw new Exception("upper must between 1 and 1000.");
		}
		if(answer < 1 || answer > upper) {
			throw new Exception("answer must greater than 1 and less than upper.");
		}
		
		while(guess != answer) {
			guess = (int)Math.floor((lower + upper) / 2);
			times++;
			if(guess == answer) {
				break;
			} else if(guess < answer) {
				lower = guess + 1;
			} else {
				upper = guess - 1;
			}
		}
		
		return times;
	}

	public static void main(String[] args) {
		int upper = 643;
		int answer = 327;
		try {
			System.out.println(new GuessTheNumber().noGuesses(upper, answer));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
