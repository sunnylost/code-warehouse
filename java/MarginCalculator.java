/*
Margin is defined as the percentage of the selling price of an item or group of items which is profit. 
For example, if an item costs $80 and is sold for $100, then there is $20 profit, or 20% margin. 


You will be given a String[], items, which is all of the items sold in a single transaction. 
Each String in items will be formatted as follows: "nnn.nn nnn.nn" (quotes for clarity), 
where each n is a digit between '0' and '9' inclusive. Each String will be exactly 13 characters in length. 
The first number listed is the price the customer paid for the item. 
The second number is what the cost to the store of the item was. 

You will create a class MarginCalculator with a method percent which will calculate the percentage of 
margin on the transaction and return it as an int, rounded down to the greatest integer less than the actual value. 

For example, let's say you were given the following String[]:
   { "012.99 008.73",
     "099.99 050.00",
     "123.45 101.07" }
The total cost is $159.80. The total price is $236.43. That means $76.63 was made on this sale. 
This would be a 32.41128% margin. Since we are rounding down, you would return 32.
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MarginCalculator {
	Pattern p = Pattern.compile("(\\d{3}\\.\\d{2}) (\\d{3}\\.\\d{2})");
	
	int percent(String[] items) throws Exception {
		if(items == null || items.length == 0 || items.length > 50) {
			throw new Exception("items' length must between 1 and 50.");
		}
		
		int len = items.length,
			i = 0;
		double totalPrices = 0,
			   totalCosts = 0;
		String item;
		Matcher m;
		
		for(; i < len; i++) {
			item = items[i];
			if(item.length() != 13) throw new Exception("item's item must be 13 characters length.");
			m = p.matcher(item);
			if(!m.matches()) throw new Exception("item's item must be formatted as \"nnn.nn nnn.nn\".");
			totalPrices += Double.parseDouble(m.group(1));
			totalCosts += Double.parseDouble(m.group(2));
		}
		if(totalPrices == 0) throw new Exception("total price must be greater than 0.");
		if(totalPrices <= totalCosts) throw new Exception("total price must be greater than total cost.");
		return (int)Math.floor((totalPrices - totalCosts) / totalPrices * 100);
	}
	
	public static void main(String[] args) {
		String[] items = {"811.22 275.32","433.89 006.48","141.28 967.41","344.47 786.23","897.47 860.61",
				 "007.42 559.29","255.72 460.00","419.35 931.19","419.25 490.52","199.78 114.44",
				 "505.63 276.58","720.96 735.00","719.90 824.46","816.58 195.94","498.68 453.05",
				 "399.48 921.39","930.88 017.63","422.20 075.39","380.22 917.27","630.83 995.87",
				 "821.07 126.87","715.73 985.62","246.23 134.64","168.28 550.33","707.28 046.72",
				 "117.76 281.87","595.43 410.45","345.28 532.42","554.24 264.34","195.73 814.87",
				 "131.98 041.28","595.13 939.47","576.04 107.70","716.00 404.75","524.24 029.96",
				 "673.49 070.97","288.09 849.43","616.34 236.34","401.96 316.33","371.18 014.27",
				 "809.63 508.33","375.68 290.84","334.66 477.89","689.54 526.35","084.77 316.51",
				 "304.76 015.91","460.63 636.56","357.84 436.20","752.24 047.64","922.10 573.12"};
		try {
			System.out.println(new MarginCalculator().percent(items));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
