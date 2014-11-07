import java.util.Arrays;

public class PlusOne {
	
	public int[] plusOne(int[] digits) {
		for(int i=digits.length-1; i>=0 ; --i) {
			int digit = digits[i];
			if(digit < 9) {
				++digits[i];
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		int[] newDigits = new int[digits.length + 1];
		newDigits[0] = 1;
		for(int i=1; i<(digits.length+1) ; ++i) {
			newDigits[i] = 0;
		}
		return newDigits;
	}
	
	public static void main(String[] args) {
		PlusOne p = new PlusOne();
		int[] array = {9,9,9,8,9,9,9,9};
		//int[] array = {9,9,9,9,9,9,9,9};
		System.out.println(Arrays.toString(p.plusOne(array)));
	}

}
