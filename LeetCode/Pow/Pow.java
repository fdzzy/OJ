/*
 * Pow(x, n) 
 * 
 * Implement pow(x, n).
 */
import java.util.ArrayList;
import java.util.List;


public class Pow {
	public double pow(double x, int n) {
    	if(n == 0) return 1;
    	if(n == 1) return x;
    	if(n == 2) return x*x;
    	if(x == 0) return 0;
    	if(n<0) {
    		x = 1 / x;
    		n *= -1;
    	}
    	int half = n/2;
    	return pow(pow(x, half), 2) * pow(x, n%2);
	}
	
    public double pow2(double x, int n) {
    	if(n == 0) return 1;
    	if(x == 0) return 0;
    	if(n<0) {
    		x = 1 / x;
    		n *= -1;
    	}
    	List<Double> results = new ArrayList<>();
    	results.add(x);
    	for(int i=1; ((long)1<<i)<=n ; i++) {
    		double tmp = results.get(i-1); 
    		results.add(tmp * tmp);
    	}

    	double product = 1;
    	while(n > 0) {
    		int i=0;
    		while(((long)1<<i) <= n) i++; 
    		i--;
    		product *= results.get(i);
    		n -= (1<<i);
    		//System.out.println("n: "+ n);
    	}
        return product; 
    }
    
    public static void main(String[] args) {
    	Pow pow = new Pow();
    	System.out.println(pow.pow(5, 3));
    	System.out.println(pow.pow(5, -3));
    	System.out.println(pow.pow(1/5, -3));
    	System.out.println(pow.pow(1/5, 0));
    	System.out.println(pow.pow(5, 5));
    	System.out.println(pow.pow(0.00001, 2147483647));
    }
}
