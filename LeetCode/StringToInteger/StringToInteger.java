
public class StringToInteger {
	private static final int INT_MAX = 2147483647; 
	private static final int INT_MIN = -2147483648; 
	
	private boolean isNum(char ch) {
		return (ch >= '0' && ch <= '9');
	}
	
	public int atoi(String str) {
		if(str == null) return 0;
		str = str.trim();
		if(str.isEmpty()) return 0;
		boolean negative = false;
		int num = 0;
		int i = 0;
		char first = str.charAt(0);
		if(first == '-') {
			negative = true;
			++i;
		} else if (first == '+') {
			++i;
		}
		
		for(; i<str.length() ; ++i) {
			char ch = str.charAt(i);
			if(isNum(ch)) {
				int digit = ch - '0';
				if(negative) {
					if(num < (INT_MIN + digit)/10)
						return INT_MIN;
					num = num * 10 - digit;
				} else {
					if(num > (INT_MAX - digit)/10)
						return INT_MAX;
					num = num * 10 + digit;
				}
			} else {
				break;
			}
		}
		return num;
	}
	
	public static void main(String[] args) {
		StringToInteger s = new StringToInteger();
		String[] nums = {"", "0", "      ", "3000001", "-98", "  00010", "+1", "-76pa", "daf", 
				"2147483648", "-2147483648", "235795348959287529", "  -0000000000000000000023354500"};
		for(String num : nums) {
			System.out.println(num + ": " + s.atoi(num));
		}
		
	}

}
