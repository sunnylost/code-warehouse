/*
When a widget breaks, it is sent to the widget repair shop, 
which is capable of repairing at most numPerDay widgets per day.
Given a record of the number of widgets that arrive at the shop each morning, 
your task is to determine how many days the shop must operate to repair all the widgets, 
not counting any days the shop spends entirely idle.

For example, suppose the shop is capable of repairing at most 8 widgets per day, 
and over a stretch of 5 days, it receives 10, 0, 0, 4, and 20 widgets, respectively. 
The shop would operate on days 1 and 2, sit idle on day 3, and operate again on days 4 through 7. 
In total, the shop would operate for 6 days to repair all the widgets.

Create a class WidgetRepairs containing a method days that takes a sequence of 
arrival counts arrivals (of type int[]) and an int numPerDay, and calculates the number of days of operation.
*/
public class WidgetRepairs {
	int days(int[] arrivals, int numPerDay) throws Exception {
		if(arrivals == null || arrivals.length == 0 || arrivals.length > 20) {
			throw new Exception("arrivals' length must between 1 and 20.");
		}
		
		if(numPerDay <= 0 || numPerDay > 50) {
			throw new Exception("numPerDay must between 1 and 50.");
		}
		
		int days = 0,
			i = 0,
			len = arrivals.length,
			element,
			remains = 0;
		for(; i < len; i++) {
			element = arrivals[i];
			if(element < 0 || element > 100) {
				throw new Exception("arrival's each element must between 0 and 100.");
			}
			remains += element;
			if(remains > 0) {
				remains -= numPerDay;
				days ++;
			}
			if(remains < 0) {
				remains = 0;
			}
		}
		if(remains > 0) {
			days += Math.ceil((float)remains / numPerDay);
		}
		return days;
	}
	
	public static void main(String[] args) {
		int numPerDay = 3;
		int[] arrivals = { 6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 5, 6 };
		try {
			System.out.println(new WidgetRepairs().days(arrivals, numPerDay));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
