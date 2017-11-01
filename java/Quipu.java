/*
The Incas used a sophisticated system of record keeping consisting of bundles of knotted cords. 
Such a bundle of cords is called a quipu. Each individual cord represents a single number. 
Surprisingly, the Incas used a base-10 positional system, just like we do today. 
Each digit of a number is represented by a cluster of adjacent knots, with spaces between neighboring clusters. 
The digit is determined by the number of knots in the cluster. For example, 
the number 243 would be represented by a cord with knots tied in the following pattern

     -XX-XXXX-XXX-
     
where each uppercase 'X' represents a knot and each '-' represents an unknotted segment of cord 
(all quotes for clarity only).
Unlike many ancient civilizations, the Incas were aware of the concept of zero, 
and used it in their quipus. A zero is represented by a cluster containing no knots. 
For example, the number 204003 would be represented by a cord with knots tied in the following pattern

     -XX--XXXX---XXX-
        ^^    ^^^
        ^^    ^^^
        ^^    two zeros between these three segments
        ^^
        one zero between these two segments
Notice how adjacent dashes signal the presence of a zero.
Your task is to translate a single quipu cord into an integer. 
The cord will be given as a String knots containing only the characters 'X' and '-'.
There will be a single '-' between each cluster of 'X's, as well as a leading '-' and a trailing '-'. 
The first cluster will not be empty.
*/
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Quipu {
	Pattern p1 = Pattern.compile("^-(-|X)+-$"),
			p2 = Pattern.compile("X{10,}");
	Matcher m;
	int MAX_NUM = 1000000;
	int MIN_NUM = 1;
	
	int readKnots(String knots) throws Exception {
		int len = knots != null ? knots.length() : 0;
		int i = 0,
			num;
		String result = "",
			   item;
		String[] items;
		
		if(len == 0 || len < 3 || len > 50) {
			throw new Exception("knots' length must between 3 and 50.");
		}
		m = p1.matcher(knots);
		if(!m.find()) {
			throw new Exception("knots can only contain 'X' and '-'.");
		}
		m = p2.matcher(knots);
		if(m.find()) {
			throw new Exception("knots cannot contain 10 consecutive 'X's.");
		}
		items = knots.substring(1, len - 1).split("-", len - 2);
		for(len = items.length; i < len; i++) {
			item = items[i];
			if(item == "") {
				result += "0";
			} else {
				result += item.length();
			}
		}
		num = Integer.parseInt(result);
		if(num < MIN_NUM || num > MAX_NUM) {
			throw new Exception("input number must between " + MIN_NUM + " and " + MAX_NUM);
		}
		return num;
	}
	
	public static void main(String[] args) {
		String knots = "-X-------";
		try {
			System.out.println(new Quipu().readKnots(knots));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
