import java.util.Arrays;

/*
This task is about the scoring in the first phase of the die-game Yahtzee, where five dice are used. The score is determined by the values on the upward die faces after a roll. The player gets to choose a value, and all dice that show the chosen value are considered active. The score is simply the sum of values on active dice.

Say, for instance, that a player ends up with the die faces showing 2, 2, 3, 5 and 4. Choosing the value two makes the dice showing 2 active and yields a score of 2 + 2 = 4, while choosing 5 makes the one die showing 5 active, yielding a score of 5.

Your method will take as input an int[] toss, where each element represents the upward face of a die, and return the maximum possible score with these values.
*/
public class Yahtzee {
  int maxPoints(int[] toss) {
		int len, 
			i = 0, 
			item,
			prev = 0, 
			sum = 0, 
			max = 0;
		boolean isSame = false;
		if(toss == null || toss.length == 0) return 0;
		Arrays.sort(toss);
		for(len = toss.length; i < len; i++) {
			item = toss[i];
			isSame = prev == item;
			if(isSame) {
				sum += item;
			} else {
				max = sum > max ? sum : max;
				sum = item;
			}
			prev = item;
		}
		max = sum > max ? sum : max;
		return max;
	}
	
	public static void main(String[] args) {
		int[] toss = { 6, 4, 1, 1, 3 };
		System.out.println(new Yahtzee().maxPoints(toss));
	}
}
