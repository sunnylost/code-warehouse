/*
  parse seconds into String.
*/
public class Time {
  static int MAX_TIME = 86399;
	static String splitter = ":";
	static int HOUR = 3600;
	static int MINUTE = 60;
	
	public String whatTime(int seconds) throws Exception {
		String result = "";
		int tmp;
		if(seconds < 0 || seconds > MAX_TIME) {
			throw new Exception("The seconds must between 0 and " + MAX_TIME);
		}
		
		tmp = (int)seconds / HOUR;
		result += tmp + splitter;
		seconds -= tmp * HOUR;
		tmp = (int)seconds / MINUTE;
		result += tmp + splitter;
		seconds -= tmp * MINUTE;
		result += seconds;
		return result;
	}
	
	public static void main(String[] args) {
		Time t = new Time();
		try {
			System.out.println(t.whatTime(86399));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
