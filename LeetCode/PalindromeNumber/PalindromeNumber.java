/*
 * Palindrome Number 
 * 
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * click to show spoilers.
 * 
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 * There is a more generic way of solving this problem.
 *   
 */
public class PalindromeNumber {
	
	// k starts from 0
	private int getKthDigit(int num, int k) {
		if(k <= 0) return num%10;
		for(int i=0; i<k ; ++i) {
			num /= 10;
		}
		return num%10;
	}
	
	public boolean isPalindrome(int x) {
		if(x < 0) return false;
		int digitCount = 0;
		int num = x;
		while(num != 0) {
			num /= 10;
			++digitCount;
		}
		if(digitCount == 0 || digitCount == 1) return true;
		
		for(int i=0; i<digitCount/2 ; ++i) {
			if(getKthDigit(x, i) != getKthDigit(x, digitCount-1-i)) return false;
		}
		return true;
	}
	
	public boolean isPalindrome2(int x) {
		if(x < 0) return false;
		int count = 0;
		int num1 = 1;
		while((x/num1) >= 10) {
			num1 *= 10;
			++count;
		}
		int num2 = 1;
		for(int i=0; i<(count+1)/2 ; ++i) {
			int a = x / num1 % 10;
			int b = x / num2 % 10;
			if(a != b) return false;
			num1 /= 10;
			num2 *= 10;
		}
		return true;
	}
	
	public boolean isPalindrome3(int x) {
		if(x < 0) return false;
		int num = x;
		int reverse = 0;
		while(num > 0) {
			int digit = num % 10;
			reverse = reverse * 10 + digit;
			num /= 10;
		}
		return x == reverse;
	}

	public static void main(String[] args) {
		PalindromeNumber p = new PalindromeNumber();
		int[] array = {12321, 235, -423324, -1, -2147447412};  
		for(int num : array) {
			System.out.println(num + ": " + p.isPalindrome3(num));
		}
	}
}
