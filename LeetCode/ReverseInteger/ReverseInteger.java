
public class ReverseInteger {
	public int reverse(int x) {
		boolean negative = (x < 0);
		
		x = negative ? -x : x;
		String xStr = "" + x;
		StringBuilder sb = new StringBuilder();
		if(negative) sb.append("-");
		for(int i=xStr.length()-1; i>=0 ; --i) {
			sb.append(xStr.charAt(i));
		}
		int rev = 0;
		//System.out.println(sb.toString());
		try {
			rev = Integer.parseInt(sb.toString());
		} catch (Exception e) {
			throw new RuntimeException("int parse exception", e);
		}
		return rev;
	}
	
	public static void main(String[] args) {
		int[] cases = {234, 5, 0, 2355, -345, 10000, -1350000, 1000000003};
		ReverseInteger r = new ReverseInteger();
		for(int x : cases) {
			System.out.println(x + ": " + r.reverse(x));
		}
	}
	
}
