/*
 The fixed-point theorem is one of those cornerstones of mathematics that reaches towards 
 all disciplines, and oddly enough it is also closely related to the ability of any 
 program to Quine itself (or to print out its own source code). Put simply, 
 the fixed-point theorem states that with certain restrictions on a real-valued function F, 
 there is always a point such that X=F(X). Taking the fixed-point theorem further, 
 you can show that any function that meets certain restrictions will start to cycle through 
 values if you keep on feeding it its own output (doing this with programs and their output 
 is one way of producing programs that Quine themselves).

One simple function that does this is the logistic function F(X)=R*X*(1-X) in the 
interval [0,1] for certain values of R. For example, 
if you start with the value X=.25 and feed it into F to get a new X, 
then feed that value into F to get yet another X, and so on, 
the values of X that are produced will converge to a small set of values that will eventually
 repeat forever, called a cycle. 

Your program will be given a double R between 0.1 and 3.569 inclusive. 
Starting with X=.25, generate the first 200,000 iterations of F using the given value of R, 
which will stabilize values of X. Then generate 1000 more values, 
and return the range of these values (highest value - lowest value). In other words, 
you will be finding the range of the values produced between iterations 200,001 and 201,000 
inclusive.
 */
public class FixedPointTheorem {
	double R;
	
	double F(double X) {
		return R * X * (1 - X);
	}
	
	double cycleRange(double r) throws Exception {
		if(r < 0.1 || r > 3.569) {
			throw new Exception("R must between 0.1 and 3.569");
		}
		R = r;
		int maxLoop = 200000,
			i = 0;
		double X = 0.25,
			   min = 0.0, 
			   max = 0.0;
		for(; i < maxLoop; i++) {
			X = F(X);
		}
		for(i = 0; i < 1000; i++) {
			X = F(X);
			if(i == 0) {
				min = max = X;
			} else {
				if(X < min) {
					min = X;
				} else if(X > max) {
					max = X;
				}
			}
		}
		return max - min;
	}
	
	public static void main(String[] args) {
		double R = 3.55;
		try {
			System.out.println(new FixedPointTheorem().cycleRange(R));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
