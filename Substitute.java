/*
A simple, easy to remember system for encoding integer amounts can be very useful. 
For example, dealers at flea markets put the information about an item on a card that they let potential buyers see. 
They find it advantageous to encode the amount they originally paid for the item on the card.
A good system is to use a substitution code, in which each digit is encoded by a letter. 
An easy to remember 10-letter word or phrase, the key, is chosen. 
Every '1' in the value is replaced by the first letter of the key, 
every '2' is replaced by the second letter of the key, and so on. Every '0' is replaced by the last letter of the key. 
Letters that do not appear in the key can be inserted anywhere without affecting the value represented by the code..
This helps to make the resulting code much harder to break (without knowing the key).

Create a class Substitute that contains the method getValue that is given the Strings key and code as input and that
returns the decoded value.
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Substitute {
	Pattern duplicate = Pattern.compile("([A-Z]).*?\\1");
	int getValue(String key, String code) throws Exception {
		int codeLen = code == null ? 0 : code.length(),
			keyLen = key == null ? 0 : key.length(),
			index = 0;
		String result = "";
		if(codeLen == 0 || codeLen > 9) {
			throw new Exception("code's length must between 1 and 9.");
		}
		if(!Pattern.compile("[A-Z]{1,9}").matcher(code).matches()) {
			throw new Exception("code must only contains uppercase character.");
		}
		if(keyLen != 10 || !Pattern.compile("[A-Z]{10}").matcher(key).matches()) {
			throw new Exception("key must only contains 10 uppercase character.");
		}
		Matcher m = duplicate.matcher(key);
		if(m.find()) {
			System.out.println(m.group(1));
			throw new Exception("key's character cannot be duplicated.");
		}
		
		for(int i = 0; i < codeLen; i++) {
			index = key.indexOf(code.charAt(i));
			if(index > -1) {
				index = index == (keyLen - 1) ? 0 : (index + 1);
				result += index;
			}
		}
		if(result == "") {
			throw new Exception("code must has at least one character which exists in key.");
		}
		return Integer.valueOf(result);
	}

	public static void main(String[] args) {
		String key = "TRADINGFEW";
		String code = "LGXWEV";
		try {
			System.out.println(new Substitute().getValue(key, code));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
