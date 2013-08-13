/*
In documents, it is frequently necessary to write monetary amounts in a standard format.
We have decided to format amounts as follows:
  the amount must start with '$'
  the amount should have a leading '0' if and only if it is less then 1 dollar.
  the amount must end with a decimal point and exactly 2 following digits.
  the digits to the left of the decimal point must be separated into groups of three by commas 
      (a group of one or two digits may appear on the left).
Create a class FormatAmt that contains a method amount that takes two int's, dollars and cents, 
as inputs and returns the properly formatted String.
*/
public class FormatAmt {
	static int MAX_DOLLARS = 2000000000;
	static int MAX_CENTS = 99;
	
	String amount(int dollars, int cents) throws Exception {
		StringBuilder result = new StringBuilder();
		char[] tmp;
		
		if(dollars < 0 || dollars > MAX_DOLLARS) {
			throw new Exception("dollars must between 0 and " + MAX_DOLLARS);
		}
		
		if(cents < 0 || cents > MAX_CENTS) {
			throw new Exception("cents must between 0 and " + MAX_CENTS);
		}
		tmp = String.valueOf(dollars).toCharArray();
		int len = tmp.length, i = 1;
		if(len <= 3) {
			result.append(tmp);
		} else {
			while(i <= len) {
				result.append(tmp[len - i]).append(i % 3 == 0 ? "," : "");
				i++;
			}
			result.reverse();
		}

		result.append(".").append(cents == 0 ? "00" : (cents <= 9 ? "0" + cents : cents));
		return "$" + (result.indexOf(",") == 0 ? result.substring(1, result.length()) : result.toString());
	}
	
	public static void main(String[] args) {
		int dollars = 1000,
			cents = 1;
		try {
			System.out.println(new FormatAmt().amount(dollars, cents));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
