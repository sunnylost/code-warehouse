import java.util.Arrays;
import java.util.regex.*;

/*
Sometimes when computer programs have a limited number of colors to use, they use a technique called dithering. 
Dithering is when you use a pattern made up of different colors such that when the colors are viewed together, 
they appear like another color. For example, you can use a checkerboard pattern of black and white pixels to achieve 
the illusion of gray.

You are writing a program to determine how much of the screen is covered by a certain dithered color. 
Given a computer screen with each pixel being a certain color, and a list of all the solid colors that make up 
the dithered color, return the number of pixels on the screen that are used to make up the dithered color. 
Each pixel will be represented by a character in screen. 
Each character in screen and in dithered will be an uppercase letter ('A'-'Z') representing a color.

Assume that any pixel which is a color contained in dithered is part of the dithered color.
*/

public class DitherCounter {
  int count(String dithered, String[] screen) throws Exception {
		int len, i = 0, count = 0;
		Pattern p;
		Matcher m;
		if(dithered == null || screen == null || screen.length == 0) {
			throw new Exception("Please enter correct arguments!");
		}
		String str = Arrays.deepToString(screen);
		str = str.substring(1, str.length() - 1)
				 .replaceAll(",", "")
				 .replaceAll(" ", "");
		len = dithered.length();
		for(; i < len; i++) {
			p = Pattern.compile(dithered.charAt(i) + "");
			m = p.matcher(str);
			while (m.find())
			    count++;
		}
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		String[] screen = {
			 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
			 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
			 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
			 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
			 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX",
			 "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWX"
		 };
		System.out.println(new DitherCounter().count("ACEGIKMOQSUWY", screen));
	}
}
