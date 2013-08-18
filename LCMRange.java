/*
	The least common multiple of a group of integers is the smallest number that can be evenly divided by 
	all the integers in the group. Given two ints, first and last, 
	find the least common multiple of all the numbers between first and last, inclusive
*/
public class LCMRange {
	private int GCD(int a, int b) {
		int tmp;
		if(b > a) {
			tmp = a;
			a = b;
			b = tmp;
		}
		tmp = a % b;
		if(tmp == 0) {
			return b;
		} else {
			return GCD(b, tmp);
		}
	}
	
	int lcm(int first, int last) throws Exception {
		int lcm = first,
			i = first + 1;
		if(first < 1 || first > 12) {
			throw new Exception("first must between 1 and 12.");
		}
		
		if(last < first || last > 12) {
			throw new Exception("last must greater than first and less than or equal 12.");
		}
		
		for(; i <= last; i++) {
			lcm = lcm * i / GCD(lcm, i);
		}
		
		return lcm;
	}
	
	public static void main(String[] args) {
		int first = 1;
		int last = 12;
		try {
			System.out.println(new LCMRange().lcm(first, last));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
