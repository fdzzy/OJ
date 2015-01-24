
public class CountAndSay {
	
	private String countAndSay(String num) {
		StringBuilder result = new StringBuilder();
		char digit = num.charAt(0);
		int count = 1;
		for(int i=1; i<num.length() ; ++i) {
			char current = num.charAt(i);
			if(digit == current) ++count;
			else {
				result.append(count);
				result.append(digit);				
				digit = current;
				count = 1;
			}
		}
		result.append(count);
		result.append(digit);
		return result.toString();
	}
	
	public String countAndSay(int n) {
		String num ="1";
		for(int i=0; i<(n-1) ; ++i) {
			num = countAndSay(num);
		}
		return num;
	}
	
	public static void main(String[] args) {
		CountAndSay c = new CountAndSay();
		for(int i=1; i<=8 ; ++i) {
			System.out.println(c.countAndSay(i));
		}
	}

}
