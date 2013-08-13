import java.util.regex.Pattern;

/*
Julius Caesar used a system of cryptography, now known as Caesar Cipher, which shifted each letter 2 places 
further through the alphabet (e.g. 'A' shifts to 'C', 'R' shifts to 'T', etc.). 
At the end of the alphabet we wrap around, that is 'Y' shifts to 'A'.

We can, of course, try shifting by any number. Given an encoded text and a number of places to shift, decode it.

For example, "TOPCODER" shifted by 2 places will be encoded as "VQREQFGT". In other words, 
if given (quotes for clarity) "VQREQFGT" and 2 as input, you will return "TOPCODER". See example 0 below.
*/
public class CCipher {
	static Pattern p = Pattern.compile("[a-z]");
	static char[] alphabet = { 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
	static int baseOffset = 65;
	
	String decode(String cipherText, int shift) throws Exception {
		if(cipherText == null || cipherText == "" || cipherText.length() > 50) {
			throw new Exception("cipherText's length must between 0 and 50.");
		}
		
		if(p.matcher(cipherText).matches()) {
			throw new Exception("cipherText must all in UPPERCASE.");
		}
		
		if(shift < 0 || shift > 25) {
			throw new Exception("shift must between 0 and 25.");
		}
		int len = cipherText.length(), 
			offset = 0,
			i = 0;
		String result = "";
		for(; i < len; i++) {
			offset = cipherText.charAt(i) - baseOffset - shift;
			if(offset < 0) {
				offset += 26;
			}
			result += alphabet[offset];
		}
		return result;
	}
	
	public static void main(String[] args) {
		String cipherText = "LIPPSASVPH";
		int shift = 4;
		try {
			System.out.println(new CCipher().decode(cipherText, shift));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
