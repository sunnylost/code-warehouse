/*
A prefix code is a set of words in which no word is a prefix of another word in the set. 
A word v is said to be a prefix of a word w if w starts with v.

An important property of prefix codes is that they are uniquely decodable. 
Prefix codes are commonly used - telephone numbers are an everyday example 
(as you probably don't want a stranger to pick up the phone call you make just because his number is a prefix 
of the number you intend to dial). Prefix codes are also very popular in computer science, 
the Huffman code used for data compression being a famous example.

Given a String[] words, return the String "Yes" if that set of words is a prefix code or 
return the String "No, i" if it is not, where i is replaced by the lowest 0-based index of a String in words 
that is a prefix of another String in words. (That index should have no extra leading zeros.)
*/
public class PrefixCode {
	
	boolean hasDuplicate(String[] words) {
		int i = 0,
			j,
			len = words.length;
		for(; i < len; i++) {
			for(j = len - 1; j > i; j--) {
				if(words[j] == words[i]) return true;
			}
		}
		return false;
	}
	
	String isOne(String[] words) throws Exception {
		if(words == null || words.length == 0 || words.length > 50) {
			throw new Exception("words' length must between 1 and 50");
		}
		
		if(hasDuplicate(words)) {
			throw new Exception("words cannot have duplicate element.");
		}
		
		int len = words.length,
			i = 0,
			j,
			pos = len;
		String e1, e2;
		
		if(len == 1) return "Yes";
		for(; i < len; i++) {
			e1 = words[i];
			for(j = len - 1; j > i; j--) {
				e2 = words[j];
				if(e1.indexOf(e2) == 0) {
					pos = j < pos ? j : pos;
				} else if(e2.indexOf(e1) == 0) {
					pos = i < pos ? i : pos;
				}
			}
		}
		return pos == len ? "Yes" : "No, " + pos;
	}

	public static void main(String[] args) {
		String[] words = {"no", "nosy", "neighbors", "needed"};
		try {
			System.out.println(new PrefixCode().isOne(words));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
