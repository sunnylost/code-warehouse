/*
Tire rotation is a simple but effective part of vehicle preventive maintenance. 
Without it, the tires of a car may wear out thousands of miles early. 
The idea is to have each tire spend part of its life on each wheel of the car. 
To accomplish this, the tire on each wheel is moved to another wheel according to a pattern. 
First, we assume the wheel positions are numbered left to right, front to rear. 

From the diagram, we see that for each phase of the rotation cycle, a tire is moved from one wheel position to another, 
according to the following chart:

starting      ending
 wheel        wheel
   1 ---------> 3
   2 ---------> 4
   3 ---------> 2
   4 ---------> 1
Therefore, if our four tires are represented by A, B, C, and D, there are four valid phases of the rotation cycle:

Phase:   1        2        3        4
Tires:  A B ---> D C ---> B A ---> C D
        C D      A B      D C      B A
         ^                          |
         |__________________________|
Write a method will take a String initial and a String current, which will both represent the tires on a car. 
Each character will be a capital letter ('A'-'Z') and will represent a serial number that identifies a tire. 
initial will be the starting locations of the tires, and current will be the current locations. 
The position of a character represents the wheel that the tire is on.
The characters represent the wheels in the order: 1, 2, 3, 4 (from the diagram above). 
Using the rotation pattern above,
your method should return a 1, 2, 3, or 4 if the tires are in the 1st, 2nd, 3rd, or 4th phase of the rotation cycle.
If the tires have been rotated improperly (that is, they are not in any phase), your method should return -1.
*/
import java.util.regex.Pattern;

public class TireRotation {
	Pattern uppercase = Pattern.compile("[A-Z]{4}");
	
	private String joinArray(String[] arr) {
		StringBuilder str = new StringBuilder();
		if(arr == null) return "";
		for(int i = 0, len = arr.length; i < len; i++) {
			str.append(arr[i]);
		}
		return str.toString();
	}
	
	int getCycle(String initial, String current) throws Exception {
		String[] initArr, curArr;
		String tmp;
		int i = 2;
		
		if(initial == null || initial.length() != 4) {
			throw new Exception("initial must contains 4 characters.");
		}
		
		if(!uppercase.matcher(initial).matches()) {
			throw new Exception("initial must only contains uppercase characters.");
		}
		
		if(current == null || current.length() != 4) {
			throw new Exception("current must contains 4 characters.");
		}
		
		if(!uppercase.matcher(current).matches()) {
			throw new Exception("current must only contains uppercase characters.");
		}
		
		initArr = initial.split("(?<=[A-Z])");
		curArr = current.split("(?<=[A-Z])");
		
		if(initial.indexOf(initArr[0], 1) != -1 || initial.indexOf(initArr[1], 2) != -1 || initial.indexOf(initArr[2], 3) != -1) {
			throw new Exception("initial cannot be duplicate.");
		}
		
		if(current.indexOf(curArr[0], 1) != -1 || current.indexOf(curArr[1], 2) != -1 || current.indexOf(curArr[2], 3) != -1) {
			throw new Exception("current cannot be duplicate.");
		}
		
		if(current.indexOf(initArr[0]) == -1 || current.indexOf(initArr[1]) == -1 || current.indexOf(initArr[2]) == -1 || current.indexOf(initArr[3]) == -1) {
			throw new Exception("initial and current must contain same characters.");
		}
		
		if(initial == current) return 1;
		
		for(; i <= 4; i++) {
			tmp = initArr[3];
			initArr[3] = initArr[0];
			initArr[0] = tmp;
			tmp = initArr[2];
			initArr[2] = initArr[1];
			initArr[1] = tmp;
			tmp = initArr[3];
			initArr[3] = initArr[2];
			initArr[2] = tmp;
			if(joinArray(initArr).equals(current)) return i;
		}
		
		return -1;
	}

	public static void main(String[] args) {
		String initial = "ZAXN";
		String current = "XNAZ";
		try {
			System.out.println(new TireRotation().getCycle(initial, current));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
