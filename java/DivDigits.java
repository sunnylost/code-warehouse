/*
Create a class DivDigits containing a method howMany which takes as an argument an int number and returns 
how many digits in number that number itself is divisible by. Count all occurences of such digits in the number, 
not just the first. See examples for more information.
*/

public class DivDigits {
	static int MIN = 10000;
	static int MAX = 999999999;
	
	int howMany(int number) throws Exception {
		if(number < MIN || number > MAX) {
			throw new Exception("Number must between " + MIN + " and " + MAX);
		}
		String num = Integer.toString(number);
		int len = num.length(),
			i = 0,
			c,
			count = 0;
		for(; i < len;i++) {
			c = num.charAt(i) - 48;
			if(c == 0) continue;
			if(number % c == 0) {
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int number = 730000000;
		try {
			System.out.println(new DivDigits().howMany(number));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
